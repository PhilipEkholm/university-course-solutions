/*
 * lab5.c
 *
 * Created: 2016-12-14 08:26:03
 *  Author: Aron Polner, Philip Ekholm
 */ 

#include <stdio.h>

#include <avr/io.h>

#include "hmi/hmi.h"
#include "numkey/numkey.h"
#include "temp/temp.h"
#include "common.h"
#include "lcd/lcd.h"

char temp_str[17];
char *p_str1 = "TEMPERATURE:";

int main(void){
	lcd_init();
	hmi_init();
	temp_init();

	lcd_set_cursor_pos(0, 0);
	sprintf(temp_str, "%u%cC", temp_read_celsius(), 0xDF);
	output_msg(p_str1, temp_str, 0);

	enum state current_state = SHOW_TEMP_C;
	enum state next_state;

	//Init the state machine
	//0xDF: Degree sign

	while(1){
		switch(current_state){
			//First state
			case SHOW_TEMP_C:
				sprintf(temp_str, "%u%cC", temp_read_celsius(), 0xDF);
				output_msg(p_str1, temp_str, 0);
				if(numkey_read() == NO_KEY || numkey_read() == '1'){
					next_state = SHOW_TEMP_C;
				}
				else if(numkey_read() == '2'){
					next_state = SHOW_TEMP_F;
				}
				else if(numkey_read() == '3'){
					next_state = SHOW_TEMP_CF;
				}
			break;
			//Next state
			case SHOW_TEMP_F:
				sprintf(temp_str, "%u%cF", temp_read_fahrenheit(), 0xDF);
				output_msg(p_str1, temp_str, 0);
				if(numkey_read() == '1'){
					next_state = SHOW_TEMP_C;
				}
				else if(numkey_read() == NO_KEY || numkey_read() == '2'){
					next_state = SHOW_TEMP_F;
				}
				else if(numkey_read() == '3'){
					next_state = SHOW_TEMP_CF;
				}
			break;
			//Third state, both fahrenheit and celsius
			case SHOW_TEMP_CF:
				sprintf(temp_str, "%u%cC %u%cF",temp_read_celsius(), 0xDF, temp_read_fahrenheit(), 0xDF);
				output_msg(p_str1, temp_str, 0);

				if(numkey_read() == NO_KEY || numkey_read() == '3'){
					next_state = SHOW_TEMP_CF;
				}
				else if(numkey_read() == '1'){
					next_state = SHOW_TEMP_C;
				}
				else if(numkey_read() == '2'){
					next_state = SHOW_TEMP_F;
				}
			break;
		}

		current_state = next_state; //Set next state
	}
}
