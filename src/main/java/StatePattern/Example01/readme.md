Bu örnekte, State pattern aynı media player kontrollerinin mevcut oynatma state'ine bağlı olarak farklı davranmasını
sağlar. Player'ın ana sınıfı, player için işin çoğunu gerçekleştiren bir state nesnesine referans içerir. Bazı
action'lar state nesnesini başka bir nesneyle değiştirebilir, bu da player'ın kullanıcı etkileşimlerine tepki verme
şeklini değiştirir.

# State abstract class

```
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
```

# Player (Context)

```
public class Player {
    private State state;
    private boolean playing = false;
    private final List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        /* ReadyState henüz yaratılmış bir class değil */
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    private void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public State getState() {
        return state;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlaying() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
```

Context'de başlangıç state'i ReadyState olarak set edildi fakat class henüz create edilmedi

# ReadyState

```
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
```

PlayingState henüz create edilmedi

# PlayingState

```
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
```

LockedState henüz create edilmedi

# LockedState

```
public class LockedState extends State{
    public LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()){
            player.setState(new ReadyState(player));
            return "Stop playing...";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.setState(new ReadyState(player));
        return "Ready";
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
```

Şimdi bir UI yazıp kodumuzu test edeceğiz;

# UI

```
public class UI {
    private Player player;
    private static JTextField textField = new JTextField();

    public UI(Player player) {
        this.player = player;
    }

    public void init(){
        JFrame frame = new JFrame("Test player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton play = new JButton("Play");
        play.addActionListener(e -> textField.setText(player.getState().onPlay()));
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));
        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(player.getState().onNext()));
        JButton prev = new JButton("Prev");
        prev.addActionListener(e -> textField.setText(player.getState().onPrevious()));
        frame.setVisible(true);
        frame.setSize(300, 100);
        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
    }
}
```

# Demo

```
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
```