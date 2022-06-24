/*
 * 	exec_task1.c
 *
 * 	Task for handling player1.
 *
 * 	Created: 2017-12-19 21:37:20
 *  Author: Philip Ekholm, Aron Polner
 */

#include <asf.h>

#include "exec_task1.h"
#include "drivers/LCDFunctions.h"
#include "drivers/lcdApplication.h"

xSemaphoreHandle player1;

void task_player1(void *pvParameters){
	/* Make sure the task runs with even intervals */
	portTickType xLastWakeTime;
	const portTickType xTimeIncrement = 1;
	xLastWakeTime = xTaskGetTickCount();

	while(1){
		vTaskDelayUntil(&xLastWakeTime, xTimeIncrement);

		/* Try to take the semaphore, otherwise do nothing */
		if(xSemaphoreTake(player1, portMAX_DELAY)==pdTRUE){
			/* Keep polling the button for a button press */
			while (1){
				if (ioport_get_pin_level(PIO_PC4_IDX)){ /* Yellow button */
					/* Turn on yellow LED to indicate it has been pressed */
					ioport_set_pin_level(PIO_PA7_IDX, HIGH);
					/* Give back the semaphore in order to measure the time */
					xSemaphoreGive(player1);
					break;
				}
			}
			vTaskDelay(1000);
		}
	}
}
