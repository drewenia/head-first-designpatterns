package CommandPattern.Example03.commands;

import CommandPattern.Example03.hardware.KitchenLights;
import CommandPattern.Example03.hardware.Music;

public class EverythingOnCommand implements Command{

    Music music;
    KitchenLights kitchenLights;

    public EverythingOnCommand(Music music, KitchenLights kitchenLights) {
        this.music = music;
        this.kitchenLights = kitchenLights;
    }

    @Override
    public void execute() {
        kitchenLights.on();
        music.on();
        music.setVolume(10);
        music.setStation(102.1F);
    }
}
