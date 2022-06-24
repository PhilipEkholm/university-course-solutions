/*
 *	exec_task2.c
 *
 *	Created: 2017-12-19 21:53:13
 *  Author: Aron Polner, Philip Ekholm
 */

#include <asf.h>

#include "exec_task2.h"

xSemaphoreHandle player2;

void task_player2(void *pvParameters){
	/* Make sure the task runs with even intervals */
	portTickType xLastWakeTime;
	const portTickType xTimeIncrement = 1;
	xLastWakeTime = xTaskGetTickCount();

	while(1){
		vTaskDelayUntil(&xLastWakeTime, xTimeIncrement);

		/* Try to take the semaphore, otherwise do nothing */
		if(xSemaphoreTake(player2, portMAX_DELAY)==pdTRUE)
		{
			/* Keep polling the button for a button press */
			while (1)
			{
				if (ioport_get_pin_level(PIO_PC5_IDX)) /* Blue button */
				{
					/* Turn on yellow LED to indicate it has been pressed */
					ioport_set_pin_level(PIO_PD10_IDX, HIGH);
					/* Give back the semaphore in order to measure the time */
					xSemaphoreGive(player2);
					break;
				}
			}

			vTaskDelay(1000);
		}
	}
}
