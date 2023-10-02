package CommandPattern.Example02;

import CommandPattern.Example02.commmand.*;
import CommandPattern.Example02.invoker.DeviceButton;
import CommandPattern.Example02.receiver.ElectronicDevice;
import CommandPattern.Example02.receiver.Radio;
import CommandPattern.Example02.receiver.Television;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ElectronicDevice newDevice = new Television();

        Command onCommand = new TVOnCommand(newDevice);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        Command offCommand = new TVOffCommand(newDevice);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        Command volumeUpCommand = new VolumeUpCommand(newDevice);
        onPressed = new DeviceButton(volumeUpCommand);
        onPressed.press();
        onPressed.press();
        onPressed.press();

        // Macro Command

        ElectronicDevice tv = new Television();
        ElectronicDevice radio = new Radio();

        List<ElectronicDevice> allDevices = new ArrayList<>();
        allDevices.add(tv);
        allDevices.add(radio);

        TurnItAllOff allDevicesOff = new TurnItAllOff(allDevices);

        DeviceButton turnThemOff = new DeviceButton(allDevicesOff);
        turnThemOff.press();
    }
}
