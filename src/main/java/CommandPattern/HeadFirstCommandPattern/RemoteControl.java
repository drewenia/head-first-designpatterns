package CommandPattern.HeadFirstCommandPattern;

import CommandPattern.HeadFirstCommandPattern.Command.Command;
import CommandPattern.HeadFirstCommandPattern.ConcreteCommand.NoCommand;

public class RemoteControl {

    /* Bu sefer uzaktan kumanda, karşılık gelen array'lerde tutacağımız yedi On ve Off command'ini ele alacak.*/
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {

        /* Yapılması gereken tek şey, constructor'da On ve Off array'lerini oluşturmak ve başlatmak.*/
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /* setCommand() methodu, bir slot konumu ve bu slotda saklanacak On ve Off command'lerini alır. Bu command'leri
    daha sonra kullanmak üzere On ve Off array'lerine yerleştirir.*/
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }


    /* Bir On veya Off düğmesine basıldığında, donanım ilgili methodları onButtonWasPushed() veya offButtonWasPushed()
    çağırmakla ilgilenir.*/
    public void onButtonWasPushed(int slot) {
        if (onCommands[slot] != null) {
            this.onCommands[slot].execute();
        }
    }

    public void offButtonWasPushed(int slot) {
        this.offCommands[slot].execute();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------ Remote Control -------\n");
        for (int i = 0; i < this.onCommands.length; i++) {
            stringBuilder.append("[slot ")
                    .append(i)
                    .append("] ")
                    .append(onCommands[i].getClass().getName())
                    .append(" ")
                    .append(offCommands[i].getClass().getName())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
