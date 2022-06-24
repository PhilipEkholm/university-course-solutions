/* ---------------------------------------------------
Space in the RAM to save the results from dice throws.
The following functions are provided:

store_stat (R16 contains the dice value)
The function will increment the
Total number of throws and the
number of throws with results equals R24.

get_stat (R24 gives the value for which the
result is retrieved. If R24 = 0, the
total number of throws shall be returned.
The result is returned in R24.

clear_stat (no parameters in nor out)
Clears all data.
--------------------------------------------------------*/



.DSEG ; The following applies to the RAM:
.ORG 0x100 ; Set starting
; address of data
; segment to 0x100

total_bytes: .BYTE 7

.CSEG

store_stat:
	// 8-bitars address
	LDI XH, high(total_bytes)
    LDI XL, low(total_bytes)
	LD  R15, X
	INC R15
	ST X, R15
	
	ADD XL, R16
	LDI R24, 0
	ADC XH, R24			; Add carry
	LD R15, X
	INC R15
	ST X, R15
	RET

get_stat:
	LDI XH, HIGH(total_bytes)
	LDI XL, LOW(total_bytes)
	ADD XL, RVAL				
	LDI RVAL, 0
	ADC XH, RVAL
	LD RVAL, X
	RET

clear_stat:
	LDI  R16, 0x00
	STS  total_bytes,	R16
	STS  total_bytes+1, R16
	STS  total_bytes+2, R16		;	BYTE 2 sätts till 0
	STS  total_bytes+3, R16
	STS  total_bytes+4, R16
	STS  total_bytes+5, R16
	STS  total_bytes+6, R16
	RET
