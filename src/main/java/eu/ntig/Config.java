package eu.ntig;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


/** Overall allocation of the GPIO pins. */
public class Config {

	final static Pin RELAY_1_PIN = RaspiPin.GPIO_08;
	final static Pin RELAY_2_PIN = RaspiPin.GPIO_09;

}


/* vim: set expandtab ts=4 sw=4: */