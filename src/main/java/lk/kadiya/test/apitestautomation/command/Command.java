package lk.kadiya.test.apitestautomation.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Command {
    Logger logger = LoggerFactory.getLogger(Command.class);
    String commandKey();

    String run() throws Exception;

    default void log(String messgage) {
        logger.info(commandKey() + " : " + messgage);
    }
}
