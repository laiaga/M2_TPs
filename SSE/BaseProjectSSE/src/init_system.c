/*
 * config_system.c
 *
 *  Created on: Oct 8, 2015
 *      Author: peter
 */

#include "init_system.h"


#include "peripheral/int/plib_int.h"
#include "peripheral/devcon/plib_devcon.h"
#include "system/devcon/sys_devcon.h"

/* configuration bits 80MHz clock for CPU and peripheral bus */

#pragma config FSRSSEL=PRIORITY_7 // Shadow registers for interrupt level 7
#pragma config FMIIEN = ON // Ethernet, we do not care
#pragma config FETHIO = ON // Default Ethernet, we do not care
#pragma config FCANIO = ON // Default CAN, we do not care
#pragma config FUSBIDIO = OFF // no USID, Port function
#pragma config FVBUSONIO = OFF // no VBUS, rather port function

#pragma config USERID = 0x001

#pragma config FPLLIDIV = DIV_2         // PLL Input Divider
#pragma config FPLLMUL  = MUL_20        // PLL Multiplier
#pragma config UPLLIDIV = DIV_2         // USB PLL Input Divider
#pragma config UPLLEN   = OFF       //  USB PLL disabled, no USB
#pragma config FPLLODIV = DIV_1         // PLL Output Divider
#pragma config FNOSC    = PRIPLL        // Oscillator Selection
#pragma config FSOSCEN  = OFF           // Secondary Oscillator Enable (KLO was off)
#pragma config IESO     = OFF           // Internal/External Switch-over
#pragma config POSCMOD  = HS            // Primary Oscillator
#pragma config OSCIOFNC = OFF           // CLKO Enable
#pragma config FPBDIV   = DIV_1         // Peripheral Clock divisor
#pragma config FCKSM    = CSDCMD        // Clock Switching & Fail Safe Clock Monitor
#pragma config WDTPS    = PS1           // Watchdog Timer Postscale
#pragma config FWDTEN   = OFF           // Watchdog Timer
#pragma config DEBUG = OFF
#pragma config ICESEL   = ICS_PGx1      // ICE/ICD Comm Channel Select
#pragma config PWP      = OFF           // Program Flash Write Protect
#pragma config BWP      = OFF           // Boot Flash Write Protect
#pragma config CP       = OFF           // Code Protect

void init_system(void){
	PLIB_INT_Disable(INT_ID_0);

	// Configure the PIC32 core for the best performance
	// at the operating frequency. The operating frequency is already set to
	// 80MHz through Device Config Registers
	//SYSTEMConfigPerformance(80000000);
	SYS_DEVCON_PerformanceConfig(80000000);
	// Circuit not designed for use with JTAG, so we have to disable it.
	SYS_DEVCON_JTAGDisable();

	// put more configuration code here






	//start interrupts
	PLIB_INT_MultiVectorSelect(INT_ID_0);
	PLIB_INT_Enable(INT_ID_0);


}

