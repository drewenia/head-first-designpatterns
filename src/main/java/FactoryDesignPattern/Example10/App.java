package FactoryDesignPattern.Example10;

import FactoryDesignPattern.Example10.abstractFactory.GUIFactory;
import FactoryDesignPattern.Example10.concreteFactory.MacOSFactory;
import FactoryDesignPattern.Example10.concreteFactory.WindowsFactory;

public class App {
    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }

    private static Application configureApplication() {
        Application application;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")){
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        application = new Application(factory);
        return application;
    }
}
