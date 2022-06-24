/*
 * error.h
 *
 * Created: 2017-12-13 09:18:01
 *  Author: Philip Ekholm, Aron Polner
 */ 

#pragma once

#include <stdint.h>

typedef uint32_t err_code;

#define ERROR_OK           (0)
#define ERROR_BASE         (0x80000000)

#define ETIMER_BASE        (ERROR_BASE + (0x01 << 16))
#define ECONSOLE_BASE      (ERROR_BASE + (0x02 << 16))
#define EDAC_BASE          (ERROR_BASE + (0x03 << 16))
#define WDT_BASE           (ERROR_BASE + (0x04 << 16))
