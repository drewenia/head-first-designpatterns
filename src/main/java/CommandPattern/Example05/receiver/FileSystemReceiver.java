package CommandPattern.Example05.receiver;


/* gerçek işi yapacak olan receiver sınıflarını oluşturmamız gerekiyor */
public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void closeFile();
}
