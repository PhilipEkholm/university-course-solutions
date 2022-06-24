/*
*  master_task.c
*
*  Master task to control the player1 and player2 task. The master task
*  is also responsible for the game logic.
*
*  Created: 2017-12-20 14:21:30
*  Author: Aron Polner, Philip Ekholm
*/
#include <asf.h>

#include "master_task.h"
#include "drivers/LCDFunctions.h"
#include "drivers/lcdApplication.h"
#include "drivers/buttons.h"
#include "drivers/DelayFunctions.h"

/* Should have been used throughout the program, but not used elsewhere due to conflicts */
#define GREEN_LED  PIO_PD9_IDX
#define YELLOW_LED PIO_PA7_IDX
#define BLUE_LED   PIO_PD10_IDX

xSemaphoreHandle player1;
xSemaphoreHandle player2;

void master_task(void *pvParameters){
	xSemaphoreTake(player1, portMAX_DELAY);
	xSemaphoreTake(player2, portMAX_DELAY);

	lcdClearDisplay();
	lcdWriteAsciiString("welcome, REACT!");
	uint32_t randomWaitingTime = 0;
	portTickType time_before = 0;
	portTickType reactionPlayer1 = 0;
	portTickType reactionPlayer2 = 0;
	uint8_t			boolPlayer1 = 1;
	uint8_t			boolPlayer2 = 1;

	while (1)
	{
		/* Check if the select button on the LCD has been pressed */
		if (readLCDbutton() == btnSELECT) {
			/* Reset variables in case one wants to play another time */
			randomWaitingTime = 0;
			time_before = 0;
			reactionPlayer1 = 0;
			reactionPlayer2 = 0;
			boolPlayer1 = 1;
			boolPlayer2 = 1;

			lcdClearDisplay();
			lcdWriteAsciiString("Game is starting...");
			/* Turn off all LED:s */
			ioport_set_pin_level(GREEN_LED, LOW);
			ioport_set_pin_level(YELLOW_LED, LOW);
			ioport_set_pin_level(BLUE_LED, LOW);

			/*
			 * By using the modulo operator, the variating delay can be between 0 and 5 secd,
			 * + 2 seconds we get the desired result. Value will "begin from 0" if over 50 000
			 */
			randomWaitingTime = 20000 + (trng_read_output_data(TRNG) % 50000);
			/* Wait the random time */
			vTaskDelay(randomWaitingTime);

			/* Check if anyone is cheating by checking beforehand if any button is pressed */
			if ((ioport_get_pin_level(PIO_PC5_IDX))==0 && (ioport_get_pin_level(PIO_PC4_IDX))==0)
			{
				/*turn big led on*/
				ioport_set_pin_level(PIO_PD9_IDX, HIGH);

				/* Give away the semaphores and allow the other tasks to check buttons */
				xSemaphoreGive(player1);
				xSemaphoreGive(player2);
				/* Get the current tick count, so we can compare later */
				time_before = xTaskGetTickCount();

				/* Polls for semaphores for 2 secs */
				for (int i=0; i<1000; i++)
				{
					/* Wait a few ticks in between */
					vTaskDelay(20);
					/* See if any semaphore is available and that this is the first time
					 * respective button has been pressed. If that's the case get the
					 * difference in ticks to measure.
					 */
					if (xSemaphoreTake(player1, 1)==pdTRUE && boolPlayer1)
					{
						reactionPlayer1 = xTaskGetTickCount()-time_before;
						boolPlayer1 = 0;
					}
					if (xSemaphoreTake(player2, 1)==pdTRUE && boolPlayer2)
					{
						reactionPlayer2 = xTaskGetTickCount()-time_before;
						boolPlayer2 = 0;
					}
				}
				lcdClearDisplay();

				/* 	Check if any player was too slow to react,
				 *	declare the other one a winner and post reaction time
				 */
				if(reactionPlayer1==0){
					lcdWriteAsciiString("P1 too slow..");
					vTaskDelay(30000);
					lcdClearDisplay();
					lcdWriteAsciiString("P2 won! ");
					lcdWrite4DigitNumber(reactionPlayer2/10);
					lcdWriteAsciiString("ms");
				}
				else if(reactionPlayer2==0){
					lcdWriteAsciiString("P2 too slow..");
					vTaskDelay(30000);
					lcdClearDisplay();
					lcdWriteAsciiString("P1 won! ");
					lcdWrite4DigitNumber(reactionPlayer1/10);
					lcdWriteAsciiString("ms");
				}
				else{
					/* converts ticks to ms */
					reactionPlayer1 = reactionPlayer1/10;
					reactionPlayer2 = reactionPlayer2/10;
					lcdWriteAsciiString("P1: ");
					lcdWrite4DigitNumber(reactionPlayer1);
					lcdWriteAsciiString("ms");
					/* Write instruction to the LCD to jump to the next row (row 1) */
					lcdWrite(0xC0, 0);

					lcdWriteAsciiString("P2: ");
					lcdWrite4DigitNumber(reactionPlayer2);
					lcdWriteAsciiString("ms");

					/* let the players see the result before moving on */
					vTaskDelay(50000);
					lcdClearDisplay();
					/* Set a clear message about who's won */
					if (reactionPlayer1 < reactionPlayer2){
						lcdWriteAsciiString("P1 has won!");
					}
					else{
						lcdWriteAsciiString("P2 has won!");
					}
				}
			}
			/* Alert that someone's been cheating */
			else{
				lcdClearDisplay();
				lcdWriteAsciiString("Someone cheated!");
			}
		}
	}
}
