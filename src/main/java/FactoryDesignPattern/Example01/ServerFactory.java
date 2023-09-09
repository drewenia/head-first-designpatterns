package FactoryDesignPattern.Example01;

public class ServerFactory {
    public static Server getServer(String type) throws Exception {
        switch (type) {
            case "mail" -> {
                return new MailServer();
            }
            case "ftp" -> {
                return new FTPServer();
            }
            default -> {
                throw new Exception("Invalid server type");
            }
        }
    }
}
