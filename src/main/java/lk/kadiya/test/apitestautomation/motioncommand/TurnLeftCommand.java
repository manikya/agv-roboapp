package lk.kadiya.test.apitestautomation.motioncommand;

import lk.kadiya.test.apitestautomation.command.CommandKey;

public class TurnLeftCommand implements MotionCommand {
    @Override
    public String commandKey() {
        return CommandKey.TurnLeft.toString();
    }

    @Override
    public String run() throws Exception {
        return null;
    }
}
