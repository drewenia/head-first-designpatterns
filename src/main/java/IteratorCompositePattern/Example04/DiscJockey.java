package IteratorCompositePattern.Example04;

public class DiscJockey {
    SongComponent songList;

    public DiscJockey(SongComponent songList) {
        this.songList = songList;
    }

    public void getSongList(){
        songList.displaySongInfo();
    }
}
