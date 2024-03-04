package IteratorCompositePattern.Example03;

import java.util.Arrays;
import java.util.Iterator;

public class SongOfThe80s implements SongIterator{
    SongInfo[] songInfos;
    int songCount = 3;
    int arrayValue = 0;

    public SongOfThe80s() {
        songInfos = new SongInfo[songCount];
        addSong("Roam", "B52", 1989);
        addSong("Cruel Summer","Bananarama",1984);
        addSong("Head Over Heels","Tears For Fears",1985);
    }

    public void addSong(String songName, String bandName, int yearReleased) {
        SongInfo song = new SongInfo(songName, bandName, yearReleased);
        songInfos[arrayValue] = song;
        arrayValue++;
    }

    @Override
    public Iterator<SongInfo> createIterator() {
        return Arrays.asList(songInfos).iterator();
    }
}
