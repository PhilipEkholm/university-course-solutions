/*
 * LED Display Application.asm
 *
 *  Created: 2016-11-18 01:12:42
 *   Author: Philip and Aron
 */

 ; Definitions of registers, etc. ("constants")

	.EQU RESET		= 0x0000 ;Point to the start of the memory
	.EQU PM_START	= 0x0056 ;Memory range 0000-0055 is reserved for IRQ-vector tables
	.EQU NO_KEY 	= 0x0F   ;No key has been pressed signal
	.DEF TEMP 		= R16    ;Use Register 16 as default register for moving things around
	.DEF RVAL 		= R23    ;Use Register 23 for storing value from keyboard

; Start of program
	.CSEG
	.ORG RESET
	RJMP init

	.ORG PM_START
	.INCLUDE "delay.inc" 		;Delay routines for longer delays
	.INCLUDE "lcd.inc"			;LCD Drivers
	.INCLUDE "keyboard.inc"		;Keyboard Drivers
	.INCLUDE "gpio.inc"			;Set up GPIO-Pins
;==============================================================================
; Basic initializations of stack pointer.
;==============================================================================
init:
	; Set stack pointer to point at the end of RAM.
	LDI TEMP, LOW(RAMEND)
	OUT SPL, TEMP
	LDI TEMP, HIGH(RAMEND)
	OUT SPH, TEMP

	CALL gpio_init
	CALL lcd_init

	RJMP main				;Jump to main part of program

main:
	LCD_WRITE_CHAR 'K' ;Print each key with a macro
	LCD_WRITE_CHAR 'E'
	LCD_WRITE_CHAR 'Y'
	LCD_WRITE_CHAR ':'

	LDI R24, 0xC0
	RCALL lcd_write_instr ;Switch to second row (0xC0), uses R24
	NOP
	NOP

loop:
	CALL read_keyboard
	LDI R24, 20
	RCALL delay_ms		;Delay 20ms, uses Register 24
	NOP
	NOP

	MOV R24, RVAL
	CPI R24, NO_KEY 	;Check if any key has been pressed
	BREQ loop 			;If the key is not pressed then return

	LDI R25, 0x30 		;Jump 48 steps in the ASCII-table
	RCALL lcd_write_chr ;Print out the code
	LDI R24, 200
	RCALL delay_ms 		;Delay 200ms to avoid switch debouncing

	RJMP loop
