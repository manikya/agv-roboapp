package lk.kadiya.test.apitestautomation.command;

import lk.kadiya.test.apitestautomation.controller.CommandController;
import lk.kadiya.test.apitestautomation.motioncommand.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Logger logger = LoggerFactory.getLogger(CommandFactory.class);
    private static Map<String, Command> commandMap;
    private static Command[] commands = new Command[]{
            new LedBlinkCommand(),
            new TurnLeftCommand(),
            new TurnRightCommand(),
            new MoveForwardCommand(),
            new MoveBackwardCommand(),
            new BreakCommand(),
    };

    private static void load() {
        if (commandMap != null) {
            return;
        }
        commandMap = new HashMap<>();
        logger.info("Loading commands for the first time. Commands array size " + commands.length);
        logger.info(Arrays.toString(commands));
        Arrays.stream(commands).forEach(command -> commandMap.put(command.commandKey(), command));
        logger.info("loaded commands "+ Arrays.toString(commandMap.keySet().toArray()));
    }

    public static Command getCommand(String commandKey) {
        load();
        if (commandMap.containsKey(commandKey)) {
            return commandMap.get(commandKey);
        }
        logger.info("Command not found for key : " + commandKey);
        return new NoSuchCommand(commandKey);
    }

    public static Command getCommand(CommandKey commandKey) {
        return getCommand(commandKey.toString());
    }
}
