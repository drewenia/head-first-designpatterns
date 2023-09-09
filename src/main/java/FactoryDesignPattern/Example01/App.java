package FactoryDesignPattern.Example01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String serverType = in.nextLine();
        System.out.println("which server down?");

        Server server = ServerFactory.getServer(serverType);
        server.resolve();
    }
}
