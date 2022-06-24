 /*
*	Delay .inc
*	Skapad av Philip Ekholm & Aron Polner
*	2016-11-12
*
*	Delay routines for longer delays. Designed to work on 16MHz MCU.
*/

delay_1_micros:
	NOP ;Add 13 NOP-instructions to delay 13 cycles.
	NOP ;Routine call and RET will take at least 3 more cycles
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP

	RET

/*
*	Fördröjer med X antal mikrosekunder
*	LDI + RCALL = 4 cycles
*	För delay micros används 12NOP, kolla excel fil
*	Lämpliga värden att mata in är mellan 5-250 för att undvika överflöde.
*/

delay_micros:
	DEC R24
	CPI R24, 0 ;If reached 0 on Register 24 counter, stop.
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	NOP
	BRNE delay_micros ;Exit if R24 has reached 0

	RET

delay_ms:
	MOV R18, R24 ;Kopiera över R24 till R18
loop_dms:
	LDI R24, 250 ;(250 * 4)us=1000us = 1ms
	RCALL delay_micros
	LDI R24, 250
	RCALL delay_micros
	LDI R24, 250
	RCALL delay_micros
	LDI R24, 250
	RCALL delay_micros
	DEC R18
	CPI R18, 0			; more loops to do?
	BRNE loop_dms		; continue!
	RET