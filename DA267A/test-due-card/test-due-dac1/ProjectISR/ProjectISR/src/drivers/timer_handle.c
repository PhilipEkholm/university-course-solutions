/*
 *	timer_handle.c
 *
 *	Created: 2017-12-13 09:39:19
 *  Author: Philip Ekholm, Aron Polner
 *
 *	Timer driver for handling use of timers in SAM3X8E
 *
 *	Timer interrupt on Timer 1 channel 0 writes out values to DAC, forming a periodic sine curve using pre-calculated values.
 *
 *	Pre-calculated values originate from the trigonometric sine-function. 
 *  By manipulating the amplitude of the function with a constant as well as an offset, we can create the function that was sought after.
 *  
 *  See Matteboken for a further explanation how this can be manipulated mathematically:
 *  https://www.matteboken.se/lektioner/matte-4/trigonometri/trigonometriska-funktioner
 *  
 *  What was sought after was a sine-wave fluxuating between 1 V and 2 V on the DAC, with a middle point at 1.5 V. We can manipulate the function
 *  to work within these values by multiplying by the amplitude as well as adding a middle value.
 *  
 *  This works well for describing the behavior of alternating voltage, see page 3 in following document:
 *  https://www.nok.se/PageFiles/108978/HeuBKapVa%cc%88xelstro%cc%88m.pdf
 *
 *  We want the function to have a middle value of 1.5, therefore we can add the constant 1.5 in order to get the mean value.
 *  We also want the function to fluxuate between 1 and 2. Since we have a mean of 1.5, we want the amplitude A of the function to be 0.5. 
 *  
 *  Therefore the function we're looking after can be described as U(t) = A * sin(t) + k, where U is the voltage at a given point in time t, 
 *  A is the amplitude of the sine wave (0.5) and k is the mean value we want the function to have (1.5)
 *
 *  Setting in the numbers gives us: U(t) = 0.5 * sin(t) + 1.5, this is the function we want to use to describe the sine wave.
 *  Unfortunately, these values can't be written to the DAC since it doesn't accept direct voltage-values, but work in the numbers from
 *  0 to 4095. Because of this we need to scale the value we get from the function U. Multiplying with the factor 4095/3.3 will make this work since
 *  We want to work with numbers from 0 to 4095 and the maximum variance is 3.3 (actually 2.7 but we can think of it as it can vary 3.3 V).
 *
 *  Due to abnormalities the amplitude A is slightly higher than theoretical value (0.75), and it has been taken into account in the calculations. 
 *  Please see document Mätningar 1501f for more information about this as well as MATLAB-plots on these. Section can be found at Appendix A.
 *
 *	These values must then be converted for writing to the DAC: RegVal = (U(t) * 4095) / 3.3
 *	Example: sin t = 1:
 *		U(t) = 0.75 + 1.5 = 2.25
 *		RegVal = (2.25 * 4095) / 3.3 = 2792, a value that can be found in the table below
 *
 *	Sampled sine values can be found under lab instructions.
 */ 

#include <asf.h>

#include "timer_handle.h"
#include "digitalIO.h"

static volatile uint16_t counter = 0;
static volatile uint16_t converted_values[] = {1861, 2218, 2520, 2722, 2792, 2722, 2520, 2218, 1861, 1505, 1203, 1001, 930, 1001, 1203, 1505};
	
static enum timer_block_channel {
	TIMER0_CH1 = 0,
	TIMER0_CH2 = 1,
	TIMER0_CH3 = 2,
	TIMER1_CH1 = 0,
	TIMER1_CH2 = 1,
	TIMER1_CH3 = 2,
	TIMER2_CH1 = 0,
	TIMER2_CH2 = 1,
	TIMER2_CH3 = 2,
};

/* ISR for timer 1 block channel 0 */
void TC3_Handler(void)
{
	/* Status must be called for every interrupt, otherwise interrupt will happen again after */
	tc_get_status(TC1, TIMER1_CH1);

	/* Write to dac, use the periodicity of the function to make it work for all "real" numbers */
	dacc_write_conversion_data(DACC, converted_values[counter % 16]);
	counter++;
}

err_code timer_handle_init(uint32_t freq)
{
	if (freq == 0)
		return ETIMER_INVAL_ARG;

	uint32_t ul_div;
	uint32_t ul_tcclks;
	uint32_t ul_sysclk = sysclk_get_cpu_hz();
	
	/* Configure TC for entered frequency and trigger on RC compare */
	tc_find_mck_divisor(freq, ul_sysclk, &ul_div, &ul_tcclks, ul_sysclk);
	/* Enable clock on this peripheral unit */
	pmc_enable_periph_clk(ID_TC3);

	tc_init(TC1, TIMER1_CH1, ul_tcclks | TC_CMR_CPCTRG);
	tc_write_rc(TC1, TIMER1_CH1, (ul_sysclk / ul_div) / freq);
	
	/* Enable interrupt on this channel through NVIC */
	NVIC_EnableIRQ((IRQn_Type) ID_TC3);
	/* Enable "local" interrupt as well */
	tc_enable_interrupt(TC1, TIMER1_CH1, TC_IER_CPCS);
	/* Start the timer */
	tc_start(TC1,TIMER1_CH1);
	
	return ERROR_OK;
}
