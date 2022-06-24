/*
 * temp.h
 *
 * This is the device driver for the LM35 temperature sensor.
 *
 * Author:	Mathias Beckius, Philip Ekholm
 *
 * Date:	2014-12-07
 */

#pragma once

#include <inttypes.h>

void regulator_init(void);
uint8_t getpotvalue(void);
uint16_t getrawvalue(void);
