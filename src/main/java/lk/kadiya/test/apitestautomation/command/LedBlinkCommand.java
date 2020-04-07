package lk.kadiya.test.apitestautomation.command;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import lk.kadiya.test.apitestautomation.service.OUTPIN;
import lk.kadiya.test.apitestautomation.service.PinHandler;
import lk.kadiya.test.apitestautomation.util.DelayUtil;

public class LedBlinkCommand implements Command{
    //Get LED pin
    private GpioPinDigitalOutput ledPin = PinHandler.getOutPin(OUTPIN.LED_PIN);

    @Override
    public String commandKey() {
        return CommandKey.BlinkLED.toString();
    }

    @Override
    public String run() throws Exception {
        log("blink started");

        //change the current state into other state eg: 1->0 or 0->1
        ledPin.toggle();
        // runs small delay. This dela value is configured in DelayUtil class
        DelayUtil.smallDelay();
        // change the state to original
        ledPin.toggle();

        log("blink end");

        return "LED blink Success";
    }
}
