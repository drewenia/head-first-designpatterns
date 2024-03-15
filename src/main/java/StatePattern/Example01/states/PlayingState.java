package StatePattern.Example01.states;

import StatePattern.Example01.ui.Player;

public class PlayingState extends State{
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        /* LockedState henüz create edilmedi */
        player.setState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing...";
    }

    @Override
    public String onPlay() {
        player.setState(new ReadyState(player));
        return "Paused";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
