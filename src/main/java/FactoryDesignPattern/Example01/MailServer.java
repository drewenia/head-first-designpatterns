package FactoryDesignPattern.Example01;

public class MailServer implements Server{
    @Override
    public void resolve() {
        System.out.println("Mail server fixed");
    }
}
