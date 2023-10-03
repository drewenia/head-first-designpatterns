package CommandPattern.Example05.command;

import CommandPattern.Example05.receiver.FileSystemReceiver;

public class WriteFileCommand implements Command{
    private final FileSystemReceiver fileSystemReceiver;

    public WriteFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.writeFile();
    }
}
