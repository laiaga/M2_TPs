/*
  Software LED driver using shift register constant current LED drivers.
  
  © Peter Niebert, Aix-Marseille Université, 2013-2015, all rights reserved
 */

#ifndef LEDDRIVER_H
#define LEDDRIVER_H

/**
   initialisation function for the module, to be called once.
 */
void init_leddriver(void);


// number of leds
#define LED_NUM 31*3

// the following macros define the access to different led
// channels
#define RED 0
#define GREEN 1
#define BLUE 2
#define LED_INDEX(number, color) ((3*(number))+color)



// an array containing levels for all leds.
typedef short led_value_t[LED_NUM];


/** program leds immediately in all/nothing rule
 * @param leds a table with led values.
 * The values result in LED state off for 0 and on
 * for any other value.
 */
void set_leds(led_value_t * leds);


/**
 * Turn on leds for bits 0 to 30 for each color. This function is useful
 * for debugging.
 */
void debug_leds(unsigned int red, unsigned int green, unsigned int blue);









#endif
