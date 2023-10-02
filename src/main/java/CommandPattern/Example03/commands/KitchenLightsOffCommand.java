package CommandPattern.Example03.commands;

import CommandPattern.Example03.hardware.KitchenLights;

public class KitchenLightsOffCommand implements Command{
    KitchenLights kitchenLights;

    public KitchenLightsOffCommand(KitchenLights kitchenLights) {
        this.kitchenLights = kitchenLights;
    }

    @Override
    public void execute() {
        kitchenLights.off();
    }
}
