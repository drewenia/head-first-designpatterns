package CommandPattern.Example02.commmand;

import CommandPattern.Example02.receiver.ElectronicDevice;

public class TVOnCommand implements Command {

    private final ElectronicDevice theDevice;

    public TVOnCommand(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.on();
    }
}
