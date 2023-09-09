package FactoryDesignPattern.Example01;

public class FTPServer implements Server{
    @Override
    public void resolve() {
        System.out.println("Ftp server fixed");
    }
}
