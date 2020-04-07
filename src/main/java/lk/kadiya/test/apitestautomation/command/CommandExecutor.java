package lk.kadiya.test.apitestautomation.command;

import lk.kadiya.test.apitestautomation.motioncommand.MotionCommand;

public class CommandExecutor {

    public static String runCommand(Command command) {
        try {
            if (command instanceof MotionCommand) {
                return runMotionCommand(command);
            }
            return runCommandAsynchronously(command);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error in running command " + command.commandKey() + " . " + e.getMessage();
        }
    }

    private static String runMotionCommand(Command command) throws Exception {
        return runCommandSynchronously(command);
    }

    private static synchronized String runCommandSynchronously(Command command) throws Exception {
        command.log("Running Synchronously");
        return "Sync : " + command.run();
    }

    private static String runCommandAsynchronously(Command command) throws Exception {
        command.log("Running Asynchronously");
        return "Async : " + command.run();
    }
}
