/*
 * stupid_blink.c
 *
 *  Created on: Oct 8, 2015
 *      Author: Peter Niebert
 */

#include "blink.h"
#include "leddriver.h"
#include "peripheral/tmr/plib_tmr.h"
#include "peripheral/int/plib_int.h"


inline void wait_period(){
	while(!PLIB_INT_SourceFlagGet(INT_ID_0,INT_SOURCE_TIMER_1));
	PLIB_INT_SourceFlagClear(INT_ID_0,INT_SOURCE_TIMER_1);

}

void start_blink(void){
	init_leddriver();

	// start a timer
	PLIB_TMR_Stop(TMR_ID_1);
	PLIB_TMR_PrescaleSelect(TMR_ID_1,TMR_PRESCALE_VALUE_256);
	PLIB_TMR_Period16BitSet(TMR_ID_1,31250); // 100ms
	PLIB_TMR_Counter16BitClear(TMR_ID_1);
	PLIB_TMR_Start(TMR_ID_1);


	// now turn on cyclicly the green LEDs in the center
	while(1){

		int i;
		for(i=25;i<31;i++){
			debug_leds(0<<i,1<<i,0<<i);
			wait_period();
		}


	}

}
