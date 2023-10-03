package CommandPattern.Example05;

import CommandPattern.Example05.command.CloseFileCommand;
import CommandPattern.Example05.command.OpenFileCommand;
import CommandPattern.Example05.command.WriteFileCommand;
import CommandPattern.Example05.invoker.FileInvoker;
import CommandPattern.Example05.receiver.FileSystemReceiver;

public class App {
    public static void main(String[] args) {
        // Receiver object
        FileSystemReceiver fileSystemReceiver = FileSystemReceiverUtil.getUnderlyingFileSystem();

        OpenFileCommand openFileCommand = new OpenFileCommand(fileSystemReceiver);

        FileInvoker invoker = new FileInvoker(openFileCommand);

        invoker.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystemReceiver);

        invoker = new FileInvoker(writeFileCommand);

        invoker.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystemReceiver);

        invoker = new FileInvoker(closeFileCommand);

        invoker.execute();
    }
}
