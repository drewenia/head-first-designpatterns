package CommandPattern.HeadFirstCommandPattern;

import CommandPattern.HeadFirstCommandPattern.ConcreteCommand.*;

public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        /* Tüm cihazları uygun konumlarına yerleştirin. */
        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living room");

        /* Tüm Light Command nesnelerini oluşturun */
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightRoomOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightRoomOff = new LightOffCommand(kitchenLight);

        /* Garaj kapısı için Open ve Close Command'leri oluşturun.*/
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        /* Stereo için On ve Off Command'leri oluşturun.*/
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        /* Şimdi tüm command'lere sahip olduğumuza göre, onları uzaktan kumanda slot'larına yükleyebiliriz*/
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightRoomOn, kitchenLightRoomOff);
        remoteControl.setCommand(3, garageDoorOpen, garageDoorClose);
        remoteControl.setCommand(4, stereoOnWithCD, stereoOff);
        System.out.println(remoteControl);

        /* Tamam, hazırız! Şimdi her slot üzerinden adım adım geçiyoruz ve On ve Off düğmesine basıyoruz.*/
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);

    }
}
