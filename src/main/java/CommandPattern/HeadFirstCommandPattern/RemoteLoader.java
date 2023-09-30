package CommandPattern.HeadFirstCommandPattern;

import CommandPattern.HeadFirstCommandPattern.Command.Command;
import CommandPattern.HeadFirstCommandPattern.ConcreteCommand.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light light = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        Command[] macroOnCommands = {lightOnCommand,stereoOnWithCDCommand};
        Command[] macroOffCommands = {lightOffCommand,stereoOffCommand};

        Command partyOn = new MacroCommand(macroOnCommands);
        Command partyOff = new MacroCommand(macroOffCommands);

        remoteControl.setCommand(0,partyOn,partyOff);
        remoteControl.onBottonWasPushed(0);
        System.out.println(remoteControl);
    }
}
