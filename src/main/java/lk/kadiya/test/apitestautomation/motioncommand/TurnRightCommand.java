package lk.kadiya.test.apitestautomation.motioncommand;

import lk.kadiya.test.apitestautomation.command.CommandKey;

public class TurnRightCommand implements MotionCommand {
    @Override
    public String commandKey() {
        return CommandKey.TurnRight.toString();
    }

    @Override
    public String run() throws Exception {
        return null;
    }
}