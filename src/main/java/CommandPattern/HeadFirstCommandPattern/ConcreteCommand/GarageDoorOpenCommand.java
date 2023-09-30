package CommandPattern.HeadFirstCommandPattern.ConcreteCommand;

import CommandPattern.HeadFirstCommandPattern.Command.Command;
import CommandPattern.HeadFirstCommandPattern.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }

    @Override
    public void undo() {
        door.close();
    }
}
