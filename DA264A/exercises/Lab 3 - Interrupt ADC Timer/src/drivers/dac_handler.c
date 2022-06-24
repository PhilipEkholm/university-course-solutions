/*
 * dac_handler.c
 *
 * Created: 2017-12-13 11:18:43
 *  Author: Aron Polner, Philip Ekholm
 */

#include <asf.h>
#include "error.h"

err_code dac_init(void){
	
	    int allOK = 1;
	    pmc_enable_periph_clk(ID_DACC);         /* DACC clock should be enabled before using it. */
	    dacc_reset(DACC);                       /* Reset DACC */
	    dacc_set_transfer_mode(DACC, 0);        /* Configure FIFO transfer mode */
	    dacc_set_timing(DACC,1,1,0);            /* 1 is shortest refresh period, 1 max. speed, 0 startup time */
	    dacc_set_channel_selection(DACC,0);     /* Disable flexible (TAG) mode and select channel 0 for DAC output */
	    allOK = dacc_enable_channel(DACC, 0);   /* Enable DAC channel 0 */
	    
		if(allOK == 1){
			return ERROR_OK;
		}
		
		return ERROR_OK;
}