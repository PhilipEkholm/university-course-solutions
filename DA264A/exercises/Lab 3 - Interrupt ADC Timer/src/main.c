/**
 * @file main.c
 *
 * @brief main file initiating all necessary hardware and then blinking LED
 *
 * @author Ulrik Ekelund, Aron Polner, Philip Ekholm
 *
 * @date 2015-12-17
 */

/*
 * Include header files for all drivers that have been imported from
 * Atmel Software Framework (ASF).
 */
#include <asf.h>
#include <stdint.h>

#include "drivers/digitalIO.h"		 /* Functions developed in Task1501a */
#include "drivers/DelayFunctions.h"
#include "drivers/consoleFunctions.h"
#include "drivers/wdt.h"
#include "drivers/dac_handler.h"
#include "drivers/timer_handle.h"

#define CONF_BOARD_KEEP_WATCHDOG_AT_INIT 1		//to keep watchdog activated at board_init

#define HIGH 1
#define LOW  0

#define DIGITAL_IO_PIN_13 13

#define DELAY_US_750000 750000

int main (void)
{
	sysclk_init();
	board_init();
	
	err_code result;

	pinMode(DIGITAL_IO_PIN_13, OUTPUT);
	delayInit();

	result = console_init();
	/* Hard to print out result if no console activated... */
	
	result = dac_init();
	if (result != ERROR_OK)
		printf("Error initializing DAC: %0xu\n", result);
	else
		printf("DAC Initialized\n");
	
	/* Frequency is decided by personnr. The one used below is Aron Polner (870804-8296), will return 2440 */
	uint32_t freq = (870804 % 1999) + 991;
	/* Since the sine function is discrete with 16 values, in order for this to work there must be a multiplier of 16 */
	result = timer_handle_init(freq * 16);
	if (result != ERROR_OK)
		printf("Error initializing Timer: %0xu\n", result);
	else
		printf("Timer Initialized\n");
	
	while (1) {
		digitalWrite(DIGITAL_IO_PIN_13, HIGH);
		delayMicroseconds(DELAY_US_750000);
		digitalWrite(DIGITAL_IO_PIN_13, LOW);
		delayMicroseconds(DELAY_US_750000);
		
		/* Reset the watchdog */
		result = watchdogReload();
		if (result != ERROR_OK)
			printf("Error feeding WDT: %0xu", result);
	}
}
