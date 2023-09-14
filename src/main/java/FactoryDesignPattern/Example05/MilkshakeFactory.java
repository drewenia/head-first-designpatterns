package FactoryDesignPattern.Example05;

import java.util.HashMap;
import java.util.Map;

public class MilkshakeFactory {
    private Map<MilkshakeName,Milkshake> milkShakeMenu;

    public MilkshakeFactory() {
        buildMilkshakeMenu();
    }

    public Milkshake prepare(MilkshakeName milkshakeName){
        if (milkshakeName == null){
            System.out.println("Please provide a milkshake name");
            return null;
        }

        System.out.println(milkshakeName + " ready");
        return milkShakeMenu.get(milkshakeName);
    }

    private void buildMilkshakeMenu() {
        milkShakeMenu = new HashMap<>();
        milkShakeMenu.put(MilkshakeName.OreoMilkshake,new OreoMilkshake());
        milkShakeMenu.put(MilkshakeName.ButterscotchMilkshake,new ButterscotchMilkshake());
        milkShakeMenu.put(MilkshakeName.VannillaMilkshake,new VannillaMilkshake());
    }
}
