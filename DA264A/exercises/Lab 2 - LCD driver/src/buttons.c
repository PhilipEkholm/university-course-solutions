/*
 * buttons.c
 *
 * Created: 2015-06-12 16:28:53
 * Author: Aron Polner, Philip Ekholm
 */ 

#include "buttons.h"
#include "adcFunctions.h"	/* Must use the value from the ADC to figure out which button */

#define ANALOG_A0         0
#define BTN_THRESHOLD     80

#define BTN_SELECT_CENTER 2420
#define BTN_LEFT_CENTER   1775
#define BTN_DOWN_CENTER   1260
#define BTN_UP_CENTER     560

buttonType readLCDbutton(void)
{
	uint32_t button_code = analogRead(ANALOG_A0);

	/* Select */
	if (button_code > BTN_SELECT_CENTER - BTN_THRESHOLD && button_code < BTN_SELECT_CENTER + BTN_THRESHOLD)
		return btnSELECT;
	else if (button_code > BTN_LEFT_CENTER - BTN_THRESHOLD && button_code < BTN_LEFT_CENTER + BTN_THRESHOLD)
		return btnLEFT;
	else if (button_code > BTN_DOWN_CENTER - BTN_THRESHOLD && button_code < BTN_DOWN_CENTER + BTN_THRESHOLD)
		return btnDOWN;
	else if (button_code > BTN_UP_CENTER - BTN_THRESHOLD && button_code < BTN_UP_CENTER + BTN_THRESHOLD)
		return btnUP;
	else if (button_code < BTN_THRESHOLD)
		return btnRIGHT;

	return btnNONE;	/* No button pressed */
}