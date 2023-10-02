package CommandPattern.Example02.commmand;

import CommandPattern.Example02.receiver.ElectronicDevice;

public class VolumeDownCommand implements Command{

    ElectronicDevice theDevice;

    public VolumeDownCommand(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.volumeDown();
    }
}
