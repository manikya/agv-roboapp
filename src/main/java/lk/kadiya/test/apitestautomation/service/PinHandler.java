package lk.kadiya.test.apitestautomation.service;

import com.pi4j.io.gpio.*;

import java.util.HashMap;
import java.util.Map;

public class PinHandler {

    private static PinHandler instance = new PinHandler();
    // create gpio controller
    private static GpioController gpio;
    // defined out pin map
    private static Map<String, GpioPinDigitalOutput> outPins;
    // defined in pin map
    private static Map<String, GpioPinDigitalInput> inPins;
    // defined pwm pin map
    private static Map<String, GpioPinPwmOutput> pwmPins;

    private PinHandler() {
        initializePins();
    }

    // First initialize pins here. Then use them
    private void initializePins() {
        gpio = GpioFactory.getInstance();
        outPins = new HashMap<>();
        inPins = new HashMap<>();
        pwmPins = new HashMap<>();

        //output pins
        outPins.put(OUTPIN.LED_PIN.toString(), gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.LOW));

        //pwm pins
        pwmPins.put(PWMPIN.LEFT_BACK.toString(), gpio.provisionPwmOutputPin(RaspiPin.GPIO_10, "Left Back"));
        pwmPins.put(PWMPIN.LEFT_FRONT.toString(), gpio.provisionPwmOutputPin(RaspiPin.GPIO_11, "Left Front"));
        pwmPins.put(PWMPIN.RIGHT_BACK.toString(), gpio.provisionPwmOutputPin(RaspiPin.GPIO_12, "Right Back"));
        pwmPins.put(PWMPIN.RIGHT_FRONT.toString(), gpio.provisionPwmOutputPin(RaspiPin.GPIO_13, "Right Front"));

        //input pins
//        inPins.put(INPIN.PIN_10.toString(), gpio.provisionDigitalInputPin(RaspiPin.GPIO_10,"Input"));
    }


    public static GpioPinDigitalOutput getOutPin(OUTPIN pin) {
        if (outPins.containsKey(pin.toString())) {
            return outPins.get(pin.toString());
        }
        throw new RuntimeException("No output pin defined as " + pin.toString());
    }

    public static GpioPinPwmOutput getPwmPin(PWMPIN pin) {
        if (pwmPins.containsKey(pin.toString())) {
            return pwmPins.get(pin.toString());
        }
        throw new RuntimeException("No PWM output pin defined as " + pin.toString());
    }

    public static GpioPinDigitalInput getInputPin(INPIN pin) {
        if (inPins.containsKey(pin.toString())) {
            return inPins.get(pin.toString());
        }
        throw new RuntimeException("No input pin defined as " + pin.toString());
    }


}
