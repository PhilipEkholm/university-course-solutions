/*
 * keyboard.inc
 *
 * Subroutines for polling the keyboard
 *
 * Author: Philip Ekholm, Aron Polner
 * Created: 2016-11-07
 */
;==============================================================================
; Definitions of registers, etc. ("constants")
;==============================================================================
map_table: .DB "147*2580369#"

;==============================================================================
; Subrutine cycles through all of the buttons. If a button is detected
; the subrutine returns the value.
; If no button is pressed, the subrutin the value 0x0F.
; R18 is used as a counter(0-12).
; R19 is used to locate the pressed button.
;==============================================================================
read_keyboard:
	LDI R18, 0			; reset counter
scan_key:
	MOV R19, R18
	LSL R19
	LSL R19
	LSL R19
	LSL R19
	OUT PORTB, R19		; set column and row
	NOP					; a minimum of 2 NOP's is necessary!
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
	SBIC PINE, 6		;Return key if press was detected
	RJMP return_key_val
	INC R18
	CPI R18, 12
	BRNE scan_key
	LDI R18, NO_KEY		; no key was pressed!
return_key_val:
	MOV RVAL, R18
	RET

;==============================================================================
; Subrutine is called  when a button is pressed.
; Subrutine adds hexvalue 0x30 to the number to define it as a ASCII char.
; Then it calls for the macro LCD_WRITE_CHAR and forwards the char in RVAL
;==============================================================================
keyboard_detect:
	CALL read_keyboard
	CALL convert
	;SUBI R16, -0x30    ;RVAL
	LCD_WRITE_CHAR R16  ;RVAL
	RET

keyboard_detect_2:
	CALL read_keyboard
	;CALL convert
	;SUBI R16, -0x30    ;RVAL
	LCD_WRITE_CHAR R16  ;RVAL
	RET

;==============================================================================
; Subrutine is used to detect when a button is released.
; Subrutine will loop infinitely until the button is released.
;==============================================================================
keyboard_release:
	SBIS PINE, 6		;If no bit is set on PINE6, then key must be released
	RET
	RJMP keyboard_release

;Uppg 4.2.3

convert:
	LDI ZH, high(map_table <<1) ;Initialize Z pointer
	LDI ZL, low(map_table <<1)
	ADD ZL, RVAL ;Add index
	LDI RVAL, 0x00
	ADC ZH, RVAL ;Add 0 to catch Carry, if present
	LPM R16, Z
	RET

keyboard_1:
	LDI R24, 0x01
	RCALL lcd_write_instr
	RCALL delay_ms
	PRINTSTRING Str_rolling
	RCALL roll_dice
	MOV R22, R16							;Copies the content to R22 since PRINTSTRING clears R16
	RCALL delay_ms
	PRINTSTRING Str_value
	SUBI R22, -0x30
	LCD_WRITE_CHAR R22
	RET