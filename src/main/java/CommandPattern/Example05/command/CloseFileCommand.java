package CommandPattern.Example05.command;

import CommandPattern.Example05.receiver.FileSystemReceiver;

public class CloseFileCommand implements Command {
    private final FileSystemReceiver fileSystemReceiver;

    public CloseFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.closeFile();
    }
}
