/*
 * Tarning1000.asm
 *
 * Author: Aron Polner, Philip Ekholm
 * Created: 2016-11-19
 */

/*
* This is the main file of the program.
*/
;==============================================================================
; Definitions of registers, etc. ("constants")
;==============================================================================

	.EQU RESET		= 0x0000
	.EQU PM_START	= 0x0056
	.EQU NO_KEY = 0x0F
	.DEF TEMP = R16
	.DEF RVAL = R24		; RVAL = "Return value"

;==============================================================================
; Start of program
; Includes necessary files.
;==============================================================================

	.CSEG
	.ORG RESET
	RJMP init
	.ORG PM_START
	;Drivers
	.INCLUDE "delay.inc"
	.INCLUDE "lcd.inc"
	.INCLUDE "keyboard.inc"

	;Support funcs and game
	.INCLUDE "tarning.inc"
	.INCLUDE "monitor.inc"
	.INCLUDE "stats.inc"
	.INCLUDE "stat_data.inc"

;==============================================================================
; Basic initializations of stack pointer, I/O pins, etc.
;==============================================================================


init:
	LDI TEMP, LOW(RAMEND)	; Set stack pointer to point at the end of RAM.
	OUT SPL, TEMP
	LDI TEMP, HIGH(RAMEND)
	OUT SPH, TEMP
	CALL init_pins			; Initialize pins
	CALL lcd_init			; Initialize lcd
	CALL init_monitor
	CALL init_stat
	PRINTSTRING str_1
	LDI R24, 0xC0
	RCALL lcd_write_instr ; Jump to second row display
	PRINTSTRING str_2
	LDI R24, 250			;2 seconds of delay
	RCALL delay_ms
	RCALL delay_1_s
	RCALL lcd_clear_display
	PRINTSTRING Str_press
	RCALL delay_1_s
	LDI R24, 0x01
	RCALL lcd_write_instr
	;CALL init_first_row
	RJMP main		; Jump to main part of program

;==============================================================================
; Initialize I/O pins
; Define ports as in/out.
; TEMP(R16) is used to store temporary values to be able to define ports.
;==============================================================================

init_pins:
	LDI TEMP, 0x00
	OUT DDRE, TEMP
	LDI TEMP, 0xFF
	OUT DDRB, TEMP
	OUT PORTB, TEMP	 ;Add pull-up resistance
	LDI TEMP, 0xF0
	OUT DDRF, TEMP
	OUT DDRD, TEMP
	OUT PORTD, TEMP
	RET

;==============================================================================
; Main part of program
; The main program is an infinite loop.
; Nothing "happens" until a button is pressed on the keyboard.
; Subrutines are called when a button is pressed.
;==============================================================================


	//PRINTSTRING Str_press
main:


	RCALL read_keyboard
	CPI RVAL, 12
	BREQ main		;Jump if RVAL
	CPI RVAL, 0
	BREQ key_1
	CPI RVAL, 4
	BREQ key_2
	CPI RVAL, 8
	BREQ key_3
	CPI RVAL, 6
	BREQ key_4
	RJMP main
key_1:
	RCALL keyboard_1
	RJMP main
key_2:
	RCALL showstat
	RJMP main
key_3:
	RCALL clearstat
	RJMP main
key_4:
	RCALL monitor
	RJMP main



