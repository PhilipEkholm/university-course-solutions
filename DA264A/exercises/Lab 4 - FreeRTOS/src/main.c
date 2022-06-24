/**
 *  main.c
 *
 *  ReactionTestApp
 *
 *  ReactionTestApp is an app built for using RTOS. In this specfici case FreeRTOS
 *  The game works by first setting up GPIO, delay, LCD, ADC in order to use earlier peripherals as game controls.
 *
 *  After this is done we use FreeRTOS for creating a few tasks that we want to put on schedule.
 *  the first one being the Master Task, responsible for controlling game mechanics as well as game-logic.
 *  We then have two parallell tasks named task_player1 and task_player2, responsible for checking if any player
 *  has pressed respective button.
 *
 * 	Two semaphores are used for this, one for each player. Master task takes both semaphores at the beginning
 * 	to block other tasks from running their code. When game has been setup and round is on, the semaphores
 * 	are released, allowing the other two tasks to run.
 *
 * 	When respective player has pressed the button the semaphore will be returned, and when master task
 * 	has taken back a semaphore the amount of ticks in between will be counted, and that way we get the reaction time.
 * 	If any player takes more than 2 seconds to react then the game will allow the other player to win.
 *
 * 	Finally we can check if any one player is trying to cheat by holding the button down from the beginning
 * 	by checking just before the giveaway of semaphores. This isn't perfect since any player could tap the button
 * 	really fast and hold up the button just before the check. More refined solution coming up.
 *
 *  Author: Philip Ekholm, Aron Polner
 */

#include <inttypes.h>	/* See http://en.wikipedia.org/wiki/C_data_types#Fixed-width_integer_types for more info */
#include <stdio_serial.h>
#include <asf.h>

#include "drivers/consoleFunctions.h"    /* functions to print on the terminal via USB */
#include "drivers/delayFunctions.h"	/* Just using the delay to make sure there is time to read the printout to the LCD of the tested functions */
#include "drivers/LCDFunctions.h"
#include "drivers/lcdApplication.h"
#include "drivers/adcFunctions.h"

#include "exec_task1.h"
#include "exec_task2.h"
#include "master_task.h"

/* Create our two semaphores for the game, one for each player */
xSemaphoreHandle player1;
xSemaphoreHandle player2;

/* Function not currently used, can be ignored. */

void vApplicationTickHook(void){

	ioport_set_pin_level(PIO_PA15_IDX, HIGH);

	volatile int j=0;	/* makes sure j doesn't overflow */

	for (int i=0; i<10; i++) /* The delay counter */{
		j++;	/* some easy predictable operation */
	}

	ioport_set_pin_level(PIO_PA15_IDX, LOW);

	/* Sets pin 22 & 23 low */
	ioport_set_pin_level(PIO_PB26_IDX, LOW);
	ioport_set_pin_level(PIO_PA14_IDX, LOW);
}

int main(void)
{
	sysclk_init();	/* Insert system clock initialization code here (sysclk_init()). */
	board_init();
	ioport_init();
	configureConsole();	/* Initialize the console UART used from within Atmel Studio*/
	delayInit();
	lcdInit();
	analogInit(0);
	/* Enable clock for TRNG, should be done in init-function but no other code is needed to use */
	pmc_enable_periph_clk(ID_TRNG);
	/* Enable the True Random Number Generator (TRNG) */
	trng_enable(TRNG);

	/* --------- Create binary semaphores ------------ */
	vSemaphoreCreateBinary(player1);
	vSemaphoreCreateBinary(player2);

	/* -------------------------- Config  --------------------------
	 * We had a better solution for determinating which pin to where, but we had
	 * some problems there. Hopefully this will do.
    */

	ioport_enable_pin(PIO_PB26_IDX); /* Debug measurements     -> Digital 22 */
	ioport_enable_pin(PIO_PA14_IDX); /* Debug measurements     -> Digital 23 */
	ioport_enable_pin(PIO_PD9_IDX);  /* Green LED ("big LED")  -> Digital 30 */
	ioport_enable_pin(PIO_PA7_IDX);  /* Yellow LED             -> Digital 31 */
	ioport_enable_pin(PIO_PD10_IDX); /* Blue LED               -> Digital 32 */

	ioport_enable_pin(PIO_PC4_IDX); /* Yellow button (player1) -> Digital 36 */
	ioport_enable_pin(PIO_PC5_IDX); /* Blue button (player2)   -> Digital 37 */

	/* Set all pins outputs (except buttons) */
	ioport_set_pin_dir(PIO_PB26_IDX, IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(PIO_PD6_IDX, IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(PIO_PD9_IDX, IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(PIO_PA7_IDX, IOPORT_DIR_OUTPUT);
	ioport_set_pin_dir(PIO_PD10_IDX, IOPORT_DIR_OUTPUT);

	/* Set buttons as input */
	ioport_set_pin_dir(PIO_PC4_IDX, IOPORT_DIR_INPUT);
	ioport_set_pin_dir(PIO_PC5_IDX, IOPORT_DIR_INPUT);

	/* Create a master task (controller task) which will handle the game from here */
	xTaskCreate(master_task, (const signed char * const) "master_task", TASK_MASTER_STACK_SIZE, NULL, TASK_MASTER_PRIORITY, NULL);

	/* Create our other two tasks for each player, polling the buttons */
	xTaskCreate(task_player1, (const signed char * const) "player1", TASK_PLAYER1_STACK_SIZE, NULL, TASK_PLAYER1_PRIORITY, NULL);
	xTaskCreate(task_player2, (const signed char * const) "player2", TASK_PLAYER2_STACK_SIZE, NULL, TASK_PLAYER2_PRIORITY, NULL);

	/* Start the FreeRTOS scheduler running all tasks indefinitely */
	vTaskStartScheduler();

	/* Even if scheduler should _never_ return, for standard reasons we still return 0 at the end of main */
	return 0;
}
