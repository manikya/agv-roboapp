package lk.kadiya.test.apitestautomation.motioncommand;

import lk.kadiya.test.apitestautomation.command.CommandKey;

public class MoveBackwardCommand implements MotionCommand {
    @Override
    public String commandKey() {
        return CommandKey.MoveBackward.toString();
    }

    @Override
    public String run() throws Exception {

        return null;
    }
}