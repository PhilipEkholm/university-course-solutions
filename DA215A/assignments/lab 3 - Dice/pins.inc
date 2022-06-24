/*
 * pins.inc
 *
 *  Created: 2016-11-18 11:02:58
 *   Author: Philip and Aron
 */ 

 init_pin:
	LDI TEMP, 0x00
	OUT PORTE, TEMP		;lyssna på spänning (input) Vad är DDRE här? 0? Betyder det att detta blir en pull-up?
	LDI TEMP, 0xFF

	OUT DDRB,TEMP		;sätt till utgång
	OUT PORTB, TEMP		;sätt till utgång

	OUT DDRF, TEMP		;sätt lysdioder outputs
	LDI TEMP, 0xF0

	CBI DDRE, 6			; E6 blir ingång
	LDI TEMP, 0xFF
	OUT DDRD, TEMP		;sätt ddrd till 1, ska vara utgångar
	//OUT PORTD, TEMP

	RET
