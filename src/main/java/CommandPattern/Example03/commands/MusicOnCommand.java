package CommandPattern.Example03.commands;

import CommandPattern.Example03.hardware.Music;

public class MusicOnCommand implements Command{
    Music music;

    public MusicOnCommand(Music music) {
        this.music = music;
    }

    @Override
    public void execute() {
        music.on();
        music.setVolume(5);
        music.setStation(99.9F);
    }
}
