package lk.kadiya.test.apitestautomation.motioncommand;

import lk.kadiya.test.apitestautomation.command.CommandKey;

public class BreakCommand implements MotionCommand {
    @Override
    public String commandKey() {
        return CommandKey.Break.toString();
    }

    @Override
    public String run() throws Exception {
        return null;
    }
}