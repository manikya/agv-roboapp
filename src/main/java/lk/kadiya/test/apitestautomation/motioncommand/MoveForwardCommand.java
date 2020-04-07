package lk.kadiya.test.apitestautomation.motioncommand;

import lk.kadiya.test.apitestautomation.command.CommandKey;

public class MoveForwardCommand implements MotionCommand {
    @Override
    public String commandKey() {
        return CommandKey.MoveForward.toString();
    }

    @Override
    public String run() throws Exception {
        return null;
    }
}