package CommandPattern.Example03;

import CommandPattern.Example03.commands.Command;
import CommandPattern.Example03.commands.NoOpCommand;

import java.util.Arrays;

public class AlexaDevice {
    Command[] onCommands;
    Command[] offCommands;
    int slots = 3;

    public AlexaDevice() {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        for (int i = 0; i < slots; i++) {
            onCommands[i] = new NoOpCommand();
            offCommands[i] = new NoOpCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (onCommand == null || offCommand == null){
            throw new IllegalArgumentException("Commands cannot be null");
        } else {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }
    }

    public void activateSlot(int slot){
        onCommands[slot].execute();
    }

    public void deactivateSlot(int slot){
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------- Alexa Device Controller --------\n");
        for (int i = 0; i < slots; i++) {
            sb.append("Slot #")
                    .append(i)
                    .append(" - ")
                    .append(onCommands[i].getClass().getSimpleName())
                    .append("(")
                    .append(onCommands.getClass().getSimpleName())
                    .append(")")
                    .append(" - ")
                    .append(offCommands[i].getClass().getSimpleName())
                    .append("(").append(offCommands.getClass().getSimpleName())
                    .append(")")
                    .append("\n");
        }
        return sb.toString();
    }
}
