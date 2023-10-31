package FactoryDesignPattern.Example09;

import FactoryDesignPattern.Example09.creator.Dialog;
import FactoryDesignPattern.Example09.creator.HtmlDialog;
import FactoryDesignPattern.Example09.creator.WindowsDialog;

public class App {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    private static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
