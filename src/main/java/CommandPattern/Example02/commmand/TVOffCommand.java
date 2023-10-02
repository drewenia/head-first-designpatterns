package CommandPattern.Example02.commmand;

import CommandPattern.Example02.receiver.ElectronicDevice;

public class TVOffCommand implements Command{

    ElectronicDevice theDevice;

    public TVOffCommand(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.off();
    }
}
