/*
 * lcd.h
 *
 * This file contains subroutines for communicating with a Hitachi HD44780
 * LCD controller (or compatible circuit).
 *
 * Author:	Mathias Beckius, Philip Ekholm
 *
 * Date:	2014-11-28
 */

#pragma once

#include <inttypes.h>

/*
 * To be used with lcd_write()
 */
enum lcd_register
{
	INSTRUCTION,	// to write data to the Instruction Register
	DATA			// to write data (characters) to the Data Register
};

/*
 * To be used with lcd_set_cursor_mode()
 */
enum lcd_cursor
{
	CURSOR_OFF		= 0,
	CURSOR_ON		= 1,
	CURSOR_BLINK	= 1
};

void lcd_init(void);
void lcd_write(enum lcd_register, uint8_t);
void lcd_write_str(char *);
void lcd_clear(void);
void lcd_set_cursor_mode(enum lcd_cursor);
void lcd_set_cursor_pos(uint8_t, uint8_t);
