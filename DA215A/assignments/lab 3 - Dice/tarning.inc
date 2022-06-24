/*tarning.inc
*
*	Contains subrutines for the dice
*
*	Author: Aron Polner
*	Created: 2016-11-28
*/

roll_dice:							;called upon when key one is pressed
	LDI R16, 6						;dice have 6 values
test:
	NOP
	NOP
	RCALL read_keyboard				;key-value in RVAL
	CPI RVAL, 0x00
	BREQ roll						;yes, key 1 is still pressed
	RCALL store_stat
	RCALL lcd_clear_display
	RET								;no, key is released
roll:
	DEC R16
	BREQ roll_dice					;R16 is zero, start agn at 6
	RJMP test						;no, keep rolling


