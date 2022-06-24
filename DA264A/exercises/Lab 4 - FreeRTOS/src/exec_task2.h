/*
 * 	exec_task2.h
 *
 * 	Created: 2017-12-19 21:53:27
 *  Author: Philip Ekholm, Aron Polner
 */

#pragma once

#define TASK_PLAYER2_STACK_SIZE (2048/ sizeof(portSTACK_TYPE))
#define TASK_PLAYER2_PRIORITY (1)

/* Since the semaphore is declared elsewhere, it needs to be declared extern */
extern xSemaphoreHandle player2;

void task_player2(void *pvParameters);
