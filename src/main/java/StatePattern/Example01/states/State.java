package StatePattern.Example01.states;

import StatePattern.Example01.ui.Player;

public abstract class State {
    Player player;

    /* Context kendisini state constructor'ından geçirir. Bu, gerektiğinde bir state'in bazı yararlı context verilerini
    getirmesine yardımcı olabilir.*/
    public State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
