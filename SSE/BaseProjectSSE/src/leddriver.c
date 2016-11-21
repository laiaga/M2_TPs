/*
  Software LED driver using shift register constant current LED drivers.
  
  © Peter Niebert, Aix-Marseille Université, 2013-2015

 */

#include <peripheral/ports/plib_ports.h>
#include <peripheral/pmp/plib_pmp.h>
#include "leddriver.h"




// translation of led indices to physical addresses in the LED driver

typedef struct level_bit_struct {
  char level;
  char bitmask;
} bit_level_t;

bit_level_t led_addresses[LED_NUM+3];

const bit_level_t native_led_addresses[LED_NUM+3]=
  { 
		    {15-6,~(1<<4)}, {15-7,~(1<<4)}, {15-8,~(1<<4)}, // rgb 00
		    {15-9,~(1<<4)},  {15-10,~(1<<4)},  {15-11,~(1<<4)}, // 01
		    {15-3,~(1<<4)}, {15-4,~(1<<4)}, {15-5,~(1<<4)}, // b 02
		    {15-0,~(1<<4)},  {15-1,~(1<<4)}, {15-2,~(1<<4)}, // b 03
		    {15-9,~(1<<3)},  {15-10,~(1<<3)},  {15-11,~(1<<3)}, // b 04
		    {15-6,~(1<<3)}, {15-7,~(1<<3)}, {15-8,~(1<<3)}, // b 05
		    {15-3,~(1<<3)},  {15-4,~(1<<3)},  {15-5,~(1<<3)}, // b 06
		    {15-9,~(1<<0)}, {15-10,~(1<<0)},  {15-11,~(1<<0)}, // b 07
		    {15-6,~(1<<0)},  {15-7,~(1<<0)}, {15-8,~(1<<0)}, // b 08
		    {15-3,~(1<<5)}, {15-4,~(1<<5)},  {15-5,~(1<<5)}, // b 09
		    {15-6,~(1<<5)},  {15-7,~(1<<5)}, {15-8,~(1<<5)}, // b 10
		    {15-0,~(1<<5)}, {15-1,~(1<<5)},{15-2,~(1<<5)}, // b 11
		    {15-15,~(1<<0)},  {15-15,~(1<<2)}, {15-15,~(1<<3)}, // b 12
		    {15-0,~(1<<3)}, {15-1,~(1<<3)}, {15-2,~(1<<3)}, // b 13
		    {15-3,~(1<<0)},  {15-4,~(1<<0)},  {15-5,~(1<<0)}, // b 14
		    {15-0,~(1<<0)},  {15-1,~(1<<0)}, {15-2,~(1<<0)}, // b 15
		    {15-9,~(1<<5)},  {15-10,~(1<<5)}, {15-11,~(1<<5)}, // b 16
		    {15-0,~(1<<2)}, {15-1,~(1<<2)},  {15-2,~(1<<2)}, // b 17
		    {15-0,~(1<<1)},  {15-1,~(1<<1)}, {15-2,~(1<<1)}, // b 18
		    {15-3,~(1<<1)},  {15-4,~(1<<1)}, {15-5,~(1<<1)}, // b 19
		    {15-9,~(1<<1)}, {15-10,~(1<<1)}, {15-11,~(1<<1)}, // b 20
		    {15-3,~(1<<2)}, {15-4,~(1<<2)}, {15-5,~(1<<2)}, // b 21
		    {15-9,~(1<<2)}, {15-10,~(1<<2)}, {15-11,~(1<<2)}, // b 22
		    {15-6,~(1<<1)},  {15-7,~(1<<1)},  {15-8,~(1<<1)}, // b 23
		    {15-6,~(1<<2)},  {15-7,~(1<<2)},  {15-8,~(1<<2)}, // b 24
		    {15-12,~(1<<4)},  {15-13,~(1<<4)}, {15-14,~(1<<4)}, // b 25
		    {15-12,~(1<<3)},  {15-13,~(1<<3)},  {15-14,~(1<<3)}, // b 26
		    {15-12,~(1<<0)},  {15-13,~(1<<0)},  {15-14,~(1<<0)}, // b 27
		    {15-12,~(1<<5)},  {15-13,~(1<<5)},  {15-14,~(1<<5)}, // b 28
		    {15-12,~(1<<1)}, {15-13,~(1<<1)},  {15-14,~(1<<1)}, // b 29
		    {15-12,~(1<<2)},  {15-13,~(1<<2)},  {15-14,~(1<<2)}, // b 30
		    {15-15,~(1<<1)}, // IR1
		    {15-15,~(1<<2)}, // IR2
		    {15-15,~(1<<4)} // nothing
  };







static inline void latch(void){
	PLIB_PORTS_PinClear(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_5);
	PLIB_PORTS_PinSet(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_5);
	PLIB_PORTS_PinClear(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_5);
}

void set_leds(led_value_t * leds){
	volatile unsigned char level[16];
	int i;
	for(i=0;i<16;i++)level[i]=0; // turn everything off
	// turn on leds that have values bigger than 0
	for(i=0;i<LED_NUM;i++)
	      level[led_addresses[i].level] |= ((*leds)[i]?(~led_addresses[i].bitmask) :0);
	// send data to LED drivers
	for(i=0;i<16;i++){
		PMDIN=level[i];
	}
  // wait cycle
	latch();
}


void debug_leds(unsigned int red, unsigned int green, unsigned int blue){
	led_value_t leds;
	int i;
	for(i=0;i<31;i++){
		leds[3*i]=(red>>i) &1;
		leds[3*i+1]=(green>>i) &1;
		leds[3*i+2]=(blue>>i) &1;
	}
	set_leds(&leds);
}

static const int rotateright[34] = {8, 7,15,14,20,19,23,22,24, 6, 5,13,12,18,17,21, 4, 3,11,10,16, 2, 1, 9, 0,27,29,30,26,28,25,31,32,33 };

/**
 * Reindex leds so as to simulate a physical rotation to the right of the
 * board.
 */
void set_rotation_led_indices(int rotation){
	int source,target,i;
	for(source=0;source<34;source++){
		target=source; // actual LED index
		for(i=0;i<rotation;i++) target=rotateright[target];
		for(i=0;i<3;i++)led_addresses[3*source+i]=native_led_addresses[3*target+i];
	}
}

void init_leddriver(void){
	// setup led table
	set_rotation_led_indices(0);

	 // global control of leds
	PLIB_PORTS_PinDirectionOutputSet(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_6);
	  // turn everything off
	PLIB_PORTS_PinSet(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_6);
	  //  PMP parameters for LED driver

	PLIB_PMP_AddressPortDisable(PMP_ID_0,0xFFFF); // disable all address ports


	PLIB_PMP_InterruptModeSelect(PMP_ID_0,PMP_INTERRUPT_NONE);// no interrupt generation
	PLIB_PMP_AddressIncrementModeSelect(PMP_ID_0,PMP_ADDRESS_INCREMENT_DECREMENT_DISABLE);
	PLIB_PMP_DataSizeSelect(PMP_ID_0,PMP_DATA_SIZE_8_BITS);
	PLIB_PMP_OperationModeSelect(PMP_ID_0,PMP_MASTER_READ_WRITE_STROBES_INDEPENDENT);
	PLIB_PMP_StopInIdleDisable(PMP_ID_0); // continue in idle mode
	PLIB_PMP_MultiplexModeSelect(PMP_ID_0,PMP_MUX_NONE); // no multiplexing of data and adresses
	PLIB_PMP_WriteEnableStrobePortEnable(PMP_ID_0); // enable write
	PLIB_PMP_ReadWriteStrobePortDisable(PMP_ID_0); // disable read
	PLIB_PMP_ChipSelectFunctionSelect(PMP_ID_0,PMCS1_PMCS2_AS_ADDRESS_LINES); // no CS
	PLIB_PMP_WriteEnableStrobePolaritySelect(PMP_ID_0,PMP_POLARITY_ACTIVE_HIGH);
	PLIB_PMP_ReadWriteStrobePolaritySelect(PMP_ID_0,PMP_POLARITY_ACTIVE_HIGH); // what for?
	PLIB_PMP_Enable(PMP_ID_0);


	  // init output port for latch
	PLIB_PORTS_PinDirectionOutputSet(PORTS_ID_0,PORT_CHANNEL_D,PORTS_BIT_POS_5);
	  int i;
	  // send 16 zeros
	  for(i=0;i<16;i++)
		  PLIB_PMP_MasterSend(PMP_ID_0,0);

	  latch();
	  //remove blank, put RD6 to 0;
	  PLIB_PORTS_PinClear(PORTS_ID_0,PORT_CHANNEL_D, PORTS_BIT_POS_6);

}
