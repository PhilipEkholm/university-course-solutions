/*
 * wdt.c
 *
 * Created: 2017-12-13 09:11:40
 *  Author: Philip Ekholm, Aron Polner
 */ 

#include "wdt.h"

#define WDT_PASSPHRASE 0xA5000000
#define WDT_WDRSTT     1

err_code watchdogReload(void) {
	/* Enter key phrase for WDT and reset it */
	WDT->WDT_CR = WDT_PASSPHRASE | WDT_WDRSTT;

	return ERROR_OK;
}