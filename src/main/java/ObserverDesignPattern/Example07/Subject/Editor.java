package ObserverDesignPattern.Example07.Subject;

import java.io.File;

public class Editor {

    public EventSubject subject;
    private File file;

    public Editor() {
        this.subject = new EventSubject("open","save");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        subject.notify("open",file);
    }

    public void saveFile() throws Exception {
        if (this.file != null){
            subject.notify("save",file);
        } else {
            throw new Exception("Please open a file first");
        }
    }
}
