package IteratorCompositePattern.Example03;

import java.util.Iterator;

public class DiscJockey {
    SongIterator iter70sSongs;
    SongIterator iter80sSongs;
    SongIterator iter90sSongs;

    public DiscJockey(SongIterator iter70sSongs, SongIterator iter80sSongs, SongIterator iter90sSongs) {
        this.iter70sSongs = iter70sSongs;
        this.iter80sSongs = iter80sSongs;
        this.iter90sSongs = iter90sSongs;
    }

    public void showTheSongs(){
        Iterator<SongInfo> song70s = iter70sSongs.createIterator();
        Iterator<SongInfo> song80s = iter80sSongs.createIterator();
        Iterator<SongInfo> song90s = iter90sSongs.createIterator();

        System.out.println("Songs of the 70s\n");
        printTheSongs(song70s);

        System.out.println("Song of the 80s\n");
        printTheSongs(song80s);

        System.out.println("Song of the 90s\n");
        printTheSongs(song90s);
    }

    private void printTheSongs(Iterator<SongInfo> iterator) {
        while (iterator.hasNext()){
            SongInfo song = iterator.next();
            System.out.println(song.songName());
            System.out.println(song.bandName());
            System.out.println(song.yearReleased());
        }
    }
}
