package CommandPattern.Example02.commmand;

import CommandPattern.Example02.receiver.ElectronicDevice;

public class VolumeUpCommand implements Command{

    ElectronicDevice theDevice;

    public VolumeUpCommand(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.volumeUp();
    }
}
