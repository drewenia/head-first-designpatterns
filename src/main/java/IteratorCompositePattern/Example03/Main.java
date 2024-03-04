package IteratorCompositePattern.Example03;

public class Main {
    public static void main(String[] args) {
        SongOfThe70s songOfThe70s = new SongOfThe70s();
        SongOfThe80s songOfThe80s = new SongOfThe80s();
        SongOfThe90s songOfThe90s = new SongOfThe90s();

        DiscJockey dj = new DiscJockey(songOfThe70s,songOfThe80s,songOfThe90s);
        dj.showTheSongs();
    }
}
