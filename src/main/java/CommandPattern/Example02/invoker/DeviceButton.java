package CommandPattern.Example02.invoker;

import CommandPattern.Example02.commmand.Command;

public class DeviceButton {
    Command theCommand;

    public DeviceButton(Command theCommand) {
        this.theCommand = theCommand;
    }

    public void press(){
        theCommand.execute();
    }
}
