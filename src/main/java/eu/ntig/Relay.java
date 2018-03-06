package eu.ntig;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;


/** Exposes methods to set or read relay's on/off state. */
public class Relay
{
    protected GpioPinDigitalOutput output = null;

    public void setState(boolean on)
    {
        output.setState(on ? PinState.HIGH : PinState.LOW);
    }

    public boolean getState()
    {
        return this.output.isHigh();
    }

    public Relay(Pin pin, String name)
    {
        GpioController gpio = GpioFactory.getInstance();
        output = gpio.provisionDigitalOutputPin(pin, pin.getName());
        output.setShutdownOptions(false, PinState.LOW);
        this.setState(false);
    }

    public Relay(Pin pin)
    {
        this(pin, pin.getName());
    }
}


/* vim: set expandtab ts=4 sw=4: */
