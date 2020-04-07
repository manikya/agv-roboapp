package lk.kadiya.test.apitestautomation.command;

public class NoSuchCommand implements Command {

    private String command;

    public NoSuchCommand(String command) {
        this.command = command;
    }

    @Override
    public String commandKey() {
        return "Missing Command "+command;
    }

    @Override
    public String run() throws Exception {
        String message = "No command defined for key :" + command;
        log(message);
        return message;
    }
}
