package CommandPattern.Example05;

import CommandPattern.Example05.receiver.FileSystemReceiver;
import CommandPattern.Example05.receiver.UnixFileSystemReceiver;
import CommandPattern.Example05.receiver.WindowsFileSystemReceiver;

public class FileSystemReceiverUtil {
    public static FileSystemReceiver getUnderlyingFileSystem(){
        String osName = System.getProperty("os.name");
        System.out.println("OS is : " + osName);
        if (osName.contains("Windows")){
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
