package lk.kadiya.test.apitestautomation.motioncommand;

import com.pi4j.io.gpio.GpioPinPwmOutput;
import lk.kadiya.test.apitestautomation.command.Command;
import lk.kadiya.test.apitestautomation.service.PWMPIN;
import lk.kadiya.test.apitestautomation.service.PinHandler;

public interface MotionCommand extends Command {
    GpioPinPwmOutput leftBack =  PinHandler.getPwmPin(PWMPIN.LEFT_BACK);
    GpioPinPwmOutput leftFront =  PinHandler.getPwmPin(PWMPIN.LEFT_FRONT);
    GpioPinPwmOutput rightBack =  PinHandler.getPwmPin(PWMPIN.RIGHT_BACK);
    GpioPinPwmOutput rightFront =  PinHandler.getPwmPin(PWMPIN.RIGHT_FRONT);
}
