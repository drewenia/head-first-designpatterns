package IteratorCompositePattern.Example04;

public class Main {
    public static void main(String[] args) {
        SongComponent industricalMusic = new SongGroup("Industrial", "transgressive and provocative");
        SongComponent heavyMetalMusic = new SongGroup("Heavy Metal", "genre of rock");
        SongComponent dubStepMusic = new SongGroup("DubStep", "electronic dance music");

        SongComponent everySong = new SongGroup("Song List", "Every Song Available");
        everySong.add(industricalMusic);

        industricalMusic.add(new Song("Head Like A Hole", "NIN", 1990));
        industricalMusic.add(new Song("Head Hunter", "Front 242", 1988));

        industricalMusic.add(dubStepMusic);

        dubStepMusic.add(new Song("Centipede", "Knife Party", 2012));
        dubStepMusic.add(new Song("Tetris", "Doctor P", 2011));

        everySong.add(heavyMetalMusic);

        heavyMetalMusic.add(new Song("War Pigs", "Black Sabbath", 1970));
        heavyMetalMusic.add(new Song("Ace Of Spades", "Motorhead", 1980));

        DiscJockey discJockey = new DiscJockey(everySong);
        discJockey.getSongList();
    }
}
