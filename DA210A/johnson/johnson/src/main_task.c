/*
 * nav_task.c
 *
 * Created: 4/23/2018 11:35:40 AM
 * Author:  Philip Ekholm
 * Updated: Ali Hassan
 * Updated: Daniel -> Sensor: Movement and rotation logic (2018-05-18) // Not done
 * Updated: Emil -> Sensor: Filtering data samples (2018-05-18) // Done
 */ 
#include <asf.h>
#include <stdio.h>

#include "main_task.h"
#include "motor_task.h"
#include "pin_mapper.h"
#include "drivers/encoder.h"
#include "math_functions.h"
#include "positions.h"
#include "drivers/hcsr04.h"
#include "drivers/TWI.h"

#define USE_NAV_CORRECTION       (1)
#define USE_SENSOR_DETECTION     (0)
#define USE_BOX_NAV              (1)
#define MINIMUM_CORRECTION_ANGLE (1.00)

static struct point current_pos;
static struct point earlier_pos;
static struct point box;
static struct point object;

struct point mock_positions[4] = {
	{ 50, 100 },
	{ 120, 50 },
	{ 140, 150 },
	{ 280, 260 },
};

void main_task(void *pvParameters) {
	int16_t distance, minimum_distance_to_object; /* In cm */
	double alpha, beta, correction_angle; /* In degrees */
	uint8_t mock_pos_index = 0;
	
	printf("------------Welcome------------\n");
	
	/* Read first time package and set static coordinates */
	update_positions();
	current_pos = get_pos();
	box = get_box();
	
	
	if (ioport_get_pin_level(pin_mapper(SWITCH_CURIE_NOETHER_PIN))) {
		/* Marie Curie */
		object = get_cube();
		minimum_distance_to_object = 42;
		printf("Curie selected\n");
	}
	else{
		/* Emmy Noether */
		object = get_ball();
		minimum_distance_to_object = 47;
		printf("Noether selected\n");
	}
		
	update_positions();
	current_pos = get_pos();

	distance = get_euclid_distance(object.x, object.y, current_pos.x, current_pos.y);
	#if USE_NAV_CORRECTION
		distance = distance / 2;
	#else
		distance -= minimum_distance_to_object;
	#endif
	alpha = math_get_angle_deg(math_atan2(object.x, object.y, current_pos.x, current_pos.y));
		
	struct motor_task_instruction inst = {
		.distance = distance,
		.angle = alpha
	};
		
	xQueueSend(motor_task_instruction_handle, &inst, 10);
	earlier_pos = current_pos;
	
	printf("Current pos: (%d, %d)\n", current_pos.x, current_pos.y);
	printf("Position of object: (%d, %d)\n", object.x, object.y);
	printf("First run, angle: %d, d: %d\n", (int16_t)alpha, inst.distance);

	while(USE_NAV_CORRECTION && (distance - minimum_distance_to_object) > 3) {
		/* Wait for motor task to complete */
		while(xQueuePeek(motor_task_instruction_handle, &inst, 2));

		update_positions();
		current_pos = get_pos();
		printf("Current pos: (%d, %d)\n", current_pos.x, current_pos.y);
		printf("Earlier pos: (%d, %d)\n", earlier_pos.x, earlier_pos.y);
		
		distance = get_euclid_distance(object.x, object.y, current_pos.x, current_pos.y);
		/* Drive 70 % of target distance */
		distance = distance / 2;

		/* Calculate the actual angle that was driven */
		beta = math_get_angle_deg(math_atan2(current_pos.x, current_pos.y, earlier_pos.x, earlier_pos.y));
		alpha = math_get_angle_deg(math_atan2(object.x, object.y, current_pos.x, current_pos.y));
		correction_angle = alpha - beta;
		
		printf("correction: %d, d: %d\n", (int16_t)correction_angle, distance);
		printf("Object: (%d, %d)\n", object.x, object.y);

		if (abs(correction_angle) < MINIMUM_CORRECTION_ANGLE){
			correction_angle = 0;
		}
			
		inst.distance = distance;
		inst.angle = correction_angle;

		if (xQueueSend(motor_task_instruction_handle, &inst, 5)) {
			/* Instruction successfully sent to motor task */
			earlier_pos = current_pos;
			mock_pos_index++;
		}
	}

	while(xQueuePeek(motor_task_instruction_handle, &inst, 2));
	
	/* Sensor begin */
	/*
	 * TODO M�ste ta h�nsyn till vad f�r upplocknings radie de tv� olika p�byggnaderna har gentemot avst�ndet man m�ter objektet p�
	 * Vinkeln fr�n sensorn ska vara teoretiskt sett 15 grader ut�t fr�n b�da h�llen
	 * St�lkulan:
	 * M�tv�rden f�r 15 cm resulterar i en diameter p� 12 cm och upplockningen f�r st�lkulan �r 11 cm
	 * M�tv�rden f�r 18.6 cm resulterar i att objektet inte g�r att uppt�cka om det inte �r precis framf�r sensorn med 1-2 grader 
	 * och d�rmed �r det inget problem
	 *
	 * Tr�klosse: M�tv�rden indikerar att ett avst�nd p� 19 cm resulterar i en diameter p� 16 cm och p�byggnadsgruppen har fortfarande 
	 * inte l�mnat besked om deras diameter...
	 *
	 * Hur man l�ser detta finns det tv� olika alternativ:
	 * L�sning 1: G�r som i tillst�ndsmaskinen med att best�mma ett s�kert intervall (5-12 cm) och man k�r fram till 10 cm om man f�r 
	 * stabila v�rden p� tex 30 cm
	 *
	 * L�sning 2: Man drar ner intervallet innan sj�lva "filteringen" �ger rum vilket g�r att roboten blir "korkad" d� den kan f� v�rden 
	 * som �r �ver 30 cm och sen m�ste den �nd� b�rja med att rotera f�r att sedan k�ra en liten bit fram�t vilket uppreppas tills den 
	 * hittar objektet till slut.
	 *
	 * Slutsats:
	 * Implementerar en enkel l�sning f�rst och ser om detta teoretiska problem verkligen uppst�r �ven i praktiken...
	 */
	
	int16_t distance_to_move; // Distance the robot has to move for picking up an object
	const int step_forward = 5.6; // How much the robot will move forward in attempt to find an object
	const int distance_from_plattform = 6; // The sensor is located 6 cm in front of the robot
	int searching_for_obj = 1;
	int obj_distance;
	
	float rotate = 0; // How much has the robot rotated in degree
	const float rotation_deg = 22.8; // The motor task can only rotate 3.8 degree as minimum
	int moved_counter = 0; // How many times the robot will move forward when it doesn't find an object
	const int max_moved_times = 5; // Max times the robot will move forward in attempt to find an object
	float rotate_tot = 0;
	
	while(USE_SENSOR_DETECTION && searching_for_obj){
		obj_distance = hcsr04_get_distance_filtered();
		
		if (obj_distance != -1) {
			/* Found object */
			distance_to_move = obj_distance + distance_from_plattform - minimum_distance_to_object;
			rotate = 0;
			searching_for_obj = 0;
			printf("Correlate: %d\n", distance_to_move);
		}
		else {
			/* Obj not found, try rotate */
			distance_to_move = 0;
			rotate = 15;
			printf("Not found\n");
		}
		
		inst.distance = distance_to_move;
		inst.angle = rotate;
		rotate_tot += rotate;
		
		xQueueSend(motor_task_instruction_handle, &inst, 2);
		while(xQueuePeek(motor_task_instruction_handle, &inst, 2));
	}

	printf("Attempting to grab object\n");
	/* Send a message to the arm that we've found it */
	master_write_cmd(TWI1,grap_object);
	/* Do a busy wait for message back */
	vTaskDelay(22000);

	/* Finally, take us to the box */
	update_positions();
	current_pos = get_pos();
		
	alpha = math_get_angle_deg(math_atan2(300, 300, current_pos.x, current_pos.y));
	beta = math_get_angle_deg(math_atan2(current_pos.x, current_pos.y, earlier_pos.x, earlier_pos.y));
		
	distance = get_euclid_distance(300, 300, current_pos.x, current_pos.y);
	/* Compensate for earlier rotations as well */
	correction_angle = alpha - beta;
	
	printf("correction: %d, d: %d\n", (int16_t)correction_angle, distance);
	printf("Box: (%d, %d)\n", box.x, box.y);
	
	if (abs(correction_angle) < MINIMUM_CORRECTION_ANGLE){
		correction_angle = 0;
	}
	
	inst.distance = distance;
	inst.angle = correction_angle;

	if (xQueueSend(motor_task_instruction_handle, &inst, 5)) {
		/* Instruction successfully sent to motor task */
		earlier_pos = current_pos;
	}
	
	while(xQueuePeek(motor_task_instruction_handle, &inst, 2));
	
	update_positions();
	current_pos = get_pos();
	
	alpha = math_get_angle_deg(math_atan2(box.x, box.y, current_pos.x, current_pos.y));
	beta = math_get_angle_deg(math_atan2(current_pos.x, current_pos.y, earlier_pos.x, earlier_pos.y));
	
	distance = get_euclid_distance(box.x, box.y - 45, current_pos.x, current_pos.y);
	correction_angle = alpha - beta;

	if (abs(correction_angle) < MINIMUM_CORRECTION_ANGLE){
		correction_angle = 0;
	}
		
	inst.distance = distance;
	inst.angle = correction_angle;

	if (xQueueSend(motor_task_instruction_handle, &inst, 5)) {
		/* Instruction successfully sent to motor task */
		earlier_pos = current_pos;
	}
		
	while(xQueuePeek(motor_task_instruction_handle, &inst, 2));
	
	master_write_cmd(TWI1,release_object);
	printf("Released object\n");
	/* P2 is now over. */
	printf("--------------End--------------\n");
	while(1);
}

