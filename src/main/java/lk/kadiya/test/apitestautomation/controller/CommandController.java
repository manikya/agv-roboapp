package lk.kadiya.test.apitestautomation.controller;

import lk.kadiya.test.apitestautomation.command.Command;
import lk.kadiya.test.apitestautomation.command.CommandExecutor;
import lk.kadiya.test.apitestautomation.command.CommandFactory;
import lk.kadiya.test.apitestautomation.command.CommandKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/command")
public class CommandController {

    Logger logger = LoggerFactory.getLogger(CommandController.class);

    @GetMapping(path = "/run")
    public ResponseEntity<String> runCommand(@RequestParam(value = "command") CommandKey commandKey) {
        logger.info("Command Received " + commandKey.toString());
        Command command = CommandFactory.getCommand(commandKey);
        String result = CommandExecutor.runCommand(command);
        return ResponseEntity.ok(result);
    }

}
