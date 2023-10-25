package ObserverDesignPattern.Example07;

import ObserverDesignPattern.Example07.Subject.Editor;
import ObserverDesignPattern.Example07.Observer.EmailNotificationListener;
import ObserverDesignPattern.Example07.Observer.LogOpenListener;

public class App {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.subject.subscribe("open",new LogOpenListener("file.txt"));
        editor.subject.subscribe("save",new EmailNotificationListener("admin@example.com"));

        editor.openFile("test.txt");
        try {
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
