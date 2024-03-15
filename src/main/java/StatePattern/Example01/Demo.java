package StatePattern.Example01;

import StatePattern.Example01.ui.Player;
import StatePattern.Example01.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
