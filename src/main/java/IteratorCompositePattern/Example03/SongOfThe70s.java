package IteratorCompositePattern.Example03;

import java.util.ArrayList;
import java.util.Iterator;

public class SongOfThe70s implements SongIterator{
    ArrayList<SongInfo> bestSongs;

    public SongOfThe70s() {
        bestSongs = new ArrayList<>();
        addSong("Imagine", "John Lennon", 1971);
        addSong("American Pie","Doe McLean",1970);
        addSong("I Will Survive","Gloria Gaynor",1979);
    }

    private void addSong(String songName, String bandName, int yearReleased) {
        SongInfo song = new SongInfo(songName,bandName,yearReleased);
        bestSongs.add(song);
    }

    @Override
    public Iterator<SongInfo> createIterator() {
        return bestSongs.iterator();
    }
}
