/*
 * motor.c
 *
 * Created: 2017-01-20 02:42:08
 *  Author: Aron Polner, Philip Ekholm
 */

#include <avr/io.h>
#include <inttypes.h>
#include "motor.h"
#include "../common.h"

#define PC6_POS 6

/*
	Use the timers found on the AtMega32U4
*/

void motor_init(void){
	// set PC6 (digital pin 6) as output
	DDRC |= 1 << PC6_POS;
	// Set OC3A (PC6) to be cleared on Compare Match (Channel A)
	// COM3A1 = 1, COM3A0 = 0.
	TCCR3A |= 80;
	// Waveform Generation Mode 5, Fast PWM (8-bit)
	TCCR3A |= 0x01;
	TCCR3B |= 0x08;
	// Timer Clock, 16/64 MHz = 1/4 MHz
	TCCR3B |= 0x03;
}

void motor_set_speed(uint8_t speed){
	uint16_t motorspeed = speed * 255;

	motorspeed = motorspeed / 100;

	OCR3A = (uint8_t)motorspeed;
}