/*
 * lab6.c
 *
 * Created: 2017-01-16 21:47:42
 *  Author: Philip Ekholm, Aron Polner
 */

#include <avr/io.h>
#include <stdio.h>

#include "common.h"
#include "hmi/hmi.h"

#include "numkey/numkey.h"
#include "regulator/regulator.h"
#include "lcd/lcd.h"
#include "motor/motor.h"

char temp_str[17];
char *p_str1 = "MOTOR: OFF";
char *p_str2 = "MOTOR: ON";
char *p_str3 = "MOTOR: RUNNING";

int main(void){
	lcd_init();
	hmi_init();
	regulator_init();
	motor_init();

	lcd_set_cursor_pos(0, 0);
	output_msg(p_str1, temp_str, 0);

	enum statemotor current_state = MOTOR_OFF;
	enum statemotor next_state;

	//Init the state machine

	while(1){
		switch(current_state){
			//First state
			case MOTOR_OFF:
				sprintf(temp_str, "%u%c", getpotvalue(), 0x25);
				output_msg(p_str1, temp_str, 0);
				motor_set_speed(0);

				if (numkey_read() == '2' && getpotvalue() == 0)
					next_state = MOTOR_ON;
				else
					next_state = MOTOR_OFF;
			break;

			//Next state
			case MOTOR_ON:
				sprintf(temp_str, "%u%c", getpotvalue(), 0x25);
				output_msg(p_str2, temp_str, 0);
				if (getpotvalue() > 1)
					next_state = MOTOR_RUNNING;
				else if (numkey_read() == '1')
					next_state = MOTOR_OFF;
				else
					next_state = MOTOR_ON;
			break;

			//Third state
			case MOTOR_RUNNING:
				sprintf(temp_str, "%u%c", getpotvalue(), 0x25);
				output_msg(p_str3, temp_str, 0);
				motor_set_speed(getpotvalue());

				if(numkey_read() == '1')
					next_state = MOTOR_OFF;
				else
					next_state = MOTOR_RUNNING;
			break;
		}

		current_state = next_state;
	}
}
