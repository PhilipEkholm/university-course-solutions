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
#include "drivers/pin_mapper.h"

#define HIGH 1
#define LOW  0

#define DIGITAL_IO_PIN_13 13

#define DELAY_US_750000 750000

int main (void)
{
	sysclk_init();
	board_init();
	ioport_init();
	
	ioport_enable_pin(pin_mapper(13));
	ioport_enable_pin(pin_mapper(12));
	ioport_enable_pin(pin_mapper(11));
	ioport_enable_pin(pin_mapper(10));
	ioport_enable_pin(pin_mapper(9));
	ioport_enable_pin(pin_mapper(8));
	ioport_enable_pin(pin_mapper(7));
	ioport_enable_pin(pin_mapper(6));
	ioport_enable_pin(pin_mapper(5));
	ioport_enable_pin(pin_mapper(4));
	ioport_enable_pin(pin_mapper(3));
	ioport_enable_pin(pin_mapper(2));
	
	ioport_enable_pin(pin_mapper(22));
	ioport_enable_pin(pin_mapper(23));
	ioport_enable_pin(pin_mapper(24));
	ioport_enable_pin(pin_mapper(25));
	ioport_enable_pin(pin_mapper(26));
	ioport_enable_pin(pin_mapper(27));
	ioport_enable_pin(pin_mapper(28));
	ioport_enable_pin(pin_mapper(29));
	ioport_enable_pin(pin_mapper(30));
	ioport_enable_pin(pin_mapper(31));
	ioport_enable_pin(pin_mapper(32));
	ioport_enable_pin(pin_mapper(33));
	ioport_enable_pin(pin_mapper(34));
	ioport_enable_pin(pin_mapper(35));
	ioport_enable_pin(pin_mapper(36));
	ioport_enable_pin(pin_mapper(37));
	ioport_enable_pin(pin_mapper(38));
	ioport_enable_pin(pin_mapper(39));
	ioport_enable_pin(pin_mapper(40));
	ioport_enable_pin(pin_mapper(41));
	ioport_enable_pin(pin_mapper(42));
	ioport_enable_pin(pin_mapper(43));
	ioport_enable_pin(pin_mapper(44));
	ioport_enable_pin(pin_mapper(45));
	ioport_enable_pin(pin_mapper(46));
	ioport_enable_pin(pin_mapper(47));
	ioport_enable_pin(pin_mapper(48));
	ioport_enable_pin(pin_mapper(49));
	ioport_enable_pin(pin_mapper(50));
	ioport_enable_pin(pin_mapper(51));
	ioport_enable_pin(pin_mapper(52));
	ioport_enable_pin(pin_mapper(53));
	
	
	
	ioport_set_pin_dir(pin_mapper(13), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(12), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(11), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(10), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(9), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(8), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(7), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(6), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(5), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(4), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(3), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(2), IOPORT_DIR_OUTPUT);
	
	ioport_set_pin_dir(pin_mapper(22), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(23), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(24), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(25), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(26), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(27), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(28), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(29), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(30), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(31), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(32), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(33), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(34), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(35), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(36), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(37), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(38), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(39), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(40), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(41), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(42), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(43), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(44), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(45), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(46), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(47), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(48), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(49), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(50), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(51), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(52), IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(pin_mapper(53), IOPORT_DIR_OUTPUT);
	
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
		ioport_set_pin_level(pin_mapper(13), 1);
		ioport_set_pin_level(pin_mapper(12), 1);
		ioport_set_pin_level(pin_mapper(11), 1);
		ioport_set_pin_level(pin_mapper(10), 1);
		ioport_set_pin_level(pin_mapper(9), 1);
		ioport_set_pin_level(pin_mapper(8), 1);
		ioport_set_pin_level(pin_mapper(7), 1);
		ioport_set_pin_level(pin_mapper(6), 1);
		ioport_set_pin_level(pin_mapper(5), 1);
		ioport_set_pin_level(pin_mapper(4), 1);
		ioport_set_pin_level(pin_mapper(3), 1);
		ioport_set_pin_level(pin_mapper(2), 1);
		
		ioport_set_pin_level(pin_mapper(22), 1);
		ioport_set_pin_level(pin_mapper(23), 1);
		ioport_set_pin_level(pin_mapper(24), 1);
		ioport_set_pin_level(pin_mapper(25), 1);
		ioport_set_pin_level(pin_mapper(26), 1);
		ioport_set_pin_level(pin_mapper(27), 1);
		ioport_set_pin_level(pin_mapper(28), 1);
		ioport_set_pin_level(pin_mapper(29), 1);
		ioport_set_pin_level(pin_mapper(30), 1);
		ioport_set_pin_level(pin_mapper(31), 1);
		ioport_set_pin_level(pin_mapper(32), 1);
		ioport_set_pin_level(pin_mapper(33), 1);
		ioport_set_pin_level(pin_mapper(34), 1);
		ioport_set_pin_level(pin_mapper(35), 1);
		ioport_set_pin_level(pin_mapper(36), 1);
		ioport_set_pin_level(pin_mapper(37), 1);
		ioport_set_pin_level(pin_mapper(38), 1);
		ioport_set_pin_level(pin_mapper(39), 1);
		ioport_set_pin_level(pin_mapper(40), 1);
		ioport_set_pin_level(pin_mapper(41), 1);
		ioport_set_pin_level(pin_mapper(42), 1);
		ioport_set_pin_level(pin_mapper(43), 1);
		ioport_set_pin_level(pin_mapper(44), 1);
		ioport_set_pin_level(pin_mapper(45), 1);
		ioport_set_pin_level(pin_mapper(46), 1);
		ioport_set_pin_level(pin_mapper(47), 1);
		ioport_set_pin_level(pin_mapper(48), 1);
		ioport_set_pin_level(pin_mapper(49), 1);
		ioport_set_pin_level(pin_mapper(50), 1);
		ioport_set_pin_level(pin_mapper(51), 1);
		ioport_set_pin_level(pin_mapper(52), 1);
		ioport_set_pin_level(pin_mapper(53), 1);







		ioport_set_pin_level(pin_mapper(13), 0);
		ioport_set_pin_level(pin_mapper(12), 0);
		ioport_set_pin_level(pin_mapper(11), 0);
		ioport_set_pin_level(pin_mapper(10), 0);
		ioport_set_pin_level(pin_mapper(9), 0);
		ioport_set_pin_level(pin_mapper(8), 0);
		ioport_set_pin_level(pin_mapper(7), 0);
		ioport_set_pin_level(pin_mapper(6), 0);
		ioport_set_pin_level(pin_mapper(5), 0);
		ioport_set_pin_level(pin_mapper(4), 0);
		ioport_set_pin_level(pin_mapper(3), 0);
		ioport_set_pin_level(pin_mapper(2), 0);
		
		ioport_set_pin_level(pin_mapper(22), 0);
		ioport_set_pin_level(pin_mapper(23), 0);
		ioport_set_pin_level(pin_mapper(24), 0);
		ioport_set_pin_level(pin_mapper(25), 0);
		ioport_set_pin_level(pin_mapper(26), 0);
		ioport_set_pin_level(pin_mapper(27), 0);
		ioport_set_pin_level(pin_mapper(28), 0);
		ioport_set_pin_level(pin_mapper(29), 0);
		ioport_set_pin_level(pin_mapper(30), 0);
		ioport_set_pin_level(pin_mapper(31), 0);
		ioport_set_pin_level(pin_mapper(32), 0);
		ioport_set_pin_level(pin_mapper(33), 0);
		ioport_set_pin_level(pin_mapper(34), 0);
		ioport_set_pin_level(pin_mapper(35), 0);
		ioport_set_pin_level(pin_mapper(36), 0);
		ioport_set_pin_level(pin_mapper(37), 0);
		ioport_set_pin_level(pin_mapper(38), 0);
		ioport_set_pin_level(pin_mapper(39), 0);
		ioport_set_pin_level(pin_mapper(40), 0);
		ioport_set_pin_level(pin_mapper(41), 0);
		ioport_set_pin_level(pin_mapper(42), 0);
		ioport_set_pin_level(pin_mapper(43), 0);
		ioport_set_pin_level(pin_mapper(44), 0);
		ioport_set_pin_level(pin_mapper(45), 0);
		ioport_set_pin_level(pin_mapper(46), 0);
		ioport_set_pin_level(pin_mapper(47), 0);
		ioport_set_pin_level(pin_mapper(48), 0);
		ioport_set_pin_level(pin_mapper(49), 0);
		ioport_set_pin_level(pin_mapper(50), 0);
		ioport_set_pin_level(pin_mapper(51), 0);
		ioport_set_pin_level(pin_mapper(52), 0);
		ioport_set_pin_level(pin_mapper(53), 0);
	}
}
