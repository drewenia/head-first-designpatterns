package FactoryDesignPattern.Example05;

public class App {
    public static void main(String[] args) {
        MilkshakeFactory factory = new MilkshakeFactory();

        OreoMilkshake oreoMilkshake =
                (OreoMilkshake) factory.prepare(MilkshakeName.OreoMilkshake);

        ButterscotchMilkshake butterscotchMilkshake =
                (ButterscotchMilkshake) factory.prepare(MilkshakeName.ButterscotchMilkshake);

        VannillaMilkshake vannillaMilkshake =
                (VannillaMilkshake) factory.prepare(MilkshakeName.VannillaMilkshake);
    }
}
