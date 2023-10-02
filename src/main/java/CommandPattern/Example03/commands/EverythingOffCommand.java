package CommandPattern.Example03.commands;

import CommandPattern.Example03.hardware.KitchenLights;
import CommandPattern.Example03.hardware.Music;

public class EverythingOffCommand implements Command{

    Music music;
    KitchenLights kitchenLights;

    public EverythingOffCommand(Music music, KitchenLights kitchenLights) {
        this.music = music;
        this.kitchenLights = kitchenLights;
    }

    @Override
    public void execute() {
        kitchenLights.off();
        music.off();
        music.setStation(0);
        music.setVolume(0);
    }
}
