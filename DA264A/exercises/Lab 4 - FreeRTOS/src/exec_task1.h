/*
 *	run_parallell_tasks.h
 *
 *	Created: 2017-12-19 21:50:06
 *  Author: Philip Ekholm, Aron Polner
 */

#pragma once

#define TASK_PLAYER1_STACK_SIZE (2048/ sizeof(portSTACK_TYPE))
#define TASK_PLAYER1_PRIORITY (1)

/* Since the semaphore is declared elsewhere, it needs to be declared extern */
extern xSemaphoreHandle player1;

void task_player1(void *pvParameters);
