/*
 * wdt.h
 *
 * Created: 2017-12-13 09:12:06
 *  Author: Philip Ekholm, Aron Polner
 */ 

#pragma once

#include <stdio_serial.h>

#include "error.h"

err_code watchdogReload(void);