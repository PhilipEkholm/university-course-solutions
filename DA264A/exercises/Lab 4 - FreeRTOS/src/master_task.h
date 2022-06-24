/*
 * master_task.h
 *
 * Created: 2017-12-20 14:21:40
 *  Author: Philip Ekholm, Aron Polner
 */
#pragma once

#define TASK_MASTER_STACK_SIZE (2048/ sizeof(portSTACK_TYPE))
#define TASK_MASTER_PRIORITY (2)

/* Since the semaphores are declared elsewhere, they need to be declared extern */
extern xSemaphoreHandle player1;
extern xSemaphoreHandle player2;

void master_task(void *pvParameters);