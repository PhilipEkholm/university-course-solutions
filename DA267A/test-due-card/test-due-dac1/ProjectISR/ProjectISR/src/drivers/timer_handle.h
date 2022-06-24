/*
 * timer.h
 *
 * Created: 2017-12-13 09:39:49
 *  Author: Aron Polner, Philip Ekholm
 */ 

#pragma once

#include <stdio_serial.h>

#include "error.h"

#define ETIMER_INVAL_ARG (ETIMER_BASE + 1)

err_code timer_handle_init(uint32_t freq);