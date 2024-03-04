package IteratorCompositePattern.Example03;

import java.util.Hashtable;
import java.util.Iterator;

public class SongOfThe90s implements SongIterator {
    Hashtable<Integer, SongInfo> bestSongs;
    int hashKey = 0;

    public SongOfThe90s() {
        bestSongs = new Hashtable<>();
        addSong("Losing My Religion", "REM", 1991);
        addSong("Creep", "Radiohead", 1993);
        addSong("Walk On The Ocean", "Toad The Wet Sprocket", 1991);
    }

    public void addSong(String songName, String bandName, int yearReleased) {
        SongInfo song = new SongInfo(songName, bandName, yearReleased);
        bestSongs.put(hashKey, song);
        hashKey++;
    }

    @Override
    public Iterator<SongInfo> createIterator() {
        return bestSongs.values().iterator();
    }
}
