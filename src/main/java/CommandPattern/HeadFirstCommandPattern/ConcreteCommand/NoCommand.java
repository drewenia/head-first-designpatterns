package CommandPattern.HeadFirstCommandPattern.ConcreteCommand;

import CommandPattern.HeadFirstCommandPattern.Command.Command;

public class NoCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {

    }
}
