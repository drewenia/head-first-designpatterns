package CommandPattern.Example02.commmand;

import CommandPattern.Example02.receiver.ElectronicDevice;

import java.util.List;

public class TurnItAllOff implements Command{

    List<ElectronicDevice> theDevices;

    public TurnItAllOff(List<ElectronicDevice> theDevices) {
        this.theDevices = theDevices;
    }

    @Override
    public void execute() {
        theDevices.forEach(ElectronicDevice::off);
    }
}
