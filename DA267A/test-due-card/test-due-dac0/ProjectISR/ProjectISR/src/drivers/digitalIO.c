/*
 * digitalIO.c
 *
 * Created: 2015-06-10 15:11:18
 *  Author: Ulrik, Aron Polner, Philip Ekholm
 */ 

#include <inttypes.h>	/* See http://en.wikipedia.org/wiki/C_data_types#Fixed-width_integer_types for more info */
#include <asf.h>		/* Only needed to get the definitions for HIGH and LOW */
#include "digitalIO.h"

#define PIOB_BASE_ADDRESS 0x400E1000U

/* Pin mapping from Arduino Due to SAM3X8E */
static uint8_t due_to_sam_map_table[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,27,0,0,0,0,0,0,0,0,26};

void pinMode(int pinNumber, mode_definition mode)
{
	if (mode == OUTPUT)	/* You only have to program a function that cares about OUTPUT, and does nothing for the other values */
	{
		uint8_t sam_pin = due_to_sam_map_table[pinNumber];
	
		/* Enables PB27 */
		PIOB->PIO_PER |= (1 << sam_pin);
		/* Sets PB27 data-direction to output */
		PIOB->PIO_OER |= (1 << sam_pin);
	}
	else
	{
		/* Do nothing */
	}
}

void digitalWrite(int pinNumber, int value)
{
	uint8_t sam_pin = due_to_sam_map_table[pinNumber];
	if (value == HIGH)
	{
		/* Sets selected pin high */
		PIOB->PIO_SODR |= (1 << sam_pin);
	}
	else if (value == LOW)
	{
		/* Sets selected pin low */
		PIOB->PIO_CODR |= (1 << sam_pin);		
	}
	else
	{
		/* Something is wrong */
	}
}
