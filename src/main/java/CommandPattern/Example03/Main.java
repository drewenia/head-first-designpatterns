package CommandPattern.Example03;

import CommandPattern.Example03.commands.EverythingOffCommand;
import CommandPattern.Example03.commands.EverythingOnCommand;
import CommandPattern.Example03.commands.KitchenLightsOffCommand;
import CommandPattern.Example03.commands.KitchenLightsOnCommand;
import CommandPattern.Example03.hardware.KitchenLights;
import CommandPattern.Example03.hardware.Music;

public class Main {
    public static void main(String[] args) {
        AlexaDevice alexaDevice = new AlexaDevice();

        KitchenLights kitchenLights = new KitchenLights();

        alexaDevice.setCommand(
                0,
                new KitchenLightsOnCommand(kitchenLights),
                new KitchenLightsOffCommand(kitchenLights)
        );

        System.out.println(alexaDevice);
        alexaDevice.activateSlot(0);
        alexaDevice.deactivateSlot(0);

        System.out.println("-----------------");

        Music music = new Music();

        alexaDevice.setCommand(1, new EverythingOnCommand(music, kitchenLights), new EverythingOffCommand(music, kitchenLights));
        alexaDevice.activateSlot(1);
        alexaDevice.deactivateSlot(1);
    }
}
