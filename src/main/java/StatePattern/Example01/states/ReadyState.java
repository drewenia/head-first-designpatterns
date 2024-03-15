package StatePattern.Example01.states;

import StatePattern.Example01.ui.Player;

/* Ayrıca context'de ki state transition'larını (geçişlerini de) trigger edebilir. */
public class ReadyState extends State {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlaying();
        /* PlayingState henüz create edilmedi */
        player.setState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
