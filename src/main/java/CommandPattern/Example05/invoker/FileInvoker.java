package CommandPattern.Example05.invoker;

import CommandPattern.Example05.command.Command;

public class FileInvoker {
    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
