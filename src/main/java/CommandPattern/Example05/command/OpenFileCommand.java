package CommandPattern.Example05.command;

import CommandPattern.Example05.receiver.FileSystemReceiver;

public class OpenFileCommand implements Command{
    private final FileSystemReceiver fileSystemReceiver;

    public OpenFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.openFile();
    }
}
