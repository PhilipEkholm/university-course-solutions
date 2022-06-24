/*
 * 	GPIO.inc
 *
 *  Created: 2016-11-18 11:02:58
 *  Author: Philip and Aron
 */

 gpio_init:
	LDI TEMP, 0x00		;Set default value to register TEMP
	OUT PORTE, TEMP		;Set all ports on PORTE as inputs

	LDI TEMP, 0xFF
	OUT DDRB,TEMP
	OUT PORTB, TEMP

	OUT DDRF, TEMP
	LDI TEMP, 0xF0

	CBI DDRE, 0x06
	LDI TEMP, 0xFF
	OUT DDRD, TEMP

	RET
