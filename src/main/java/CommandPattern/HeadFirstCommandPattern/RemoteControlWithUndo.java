package CommandPattern.HeadFirstCommandPattern;

import CommandPattern.HeadFirstCommandPattern.Command.Command;
import CommandPattern.HeadFirstCommandPattern.ConcreteCommand.NoCommand;

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;

    /* İşte undo düğmesi için son çalıştırılan command'i saklayacağımız yer*/
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            this.onCommands[i] = noCommand;
            this.offCommands[i] = noCommand;
        }

        /* Diğer slotlar gibi, undo da NoCommand ile başlar, bu yüzden diğer düğmeye basmadan önce undo'ya basmak
        hiçbir şey yapmaz*/
        this.undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onBottonWasPushed(int slot){
        this.onCommands[slot].execute();

        /* Bir düğme basıldığında, command'i alırız ve önce onu çalıştırırız; ardından bu command'in bir referansını
        undoCommand instance variable'inda saklarız. Hem 'on' command'leri hem de 'off' command'leri için bunu yaparız*/
        this.undoCommand = this.onCommands[slot];
    }

    public void offButtonWasPushed(int slot){
        this.offCommands[slot].execute();

        /* Bir düğme basıldığında, command'i alırız ve önce onu çalıştırırız; ardından bu command'in bir referansını
        undoCommand instance variable'inda saklarız. Hem 'on' command'leri hem de 'off' command'leri için bunu yaparız*/
        this.undoCommand = this.offCommands[slot];
    }

    public void undoButtonWasPushed(){
        /* Undo düğmesine basıldığında, undoCommand içinde saklanan command'in undo() methodunu çağırırız. Bu, en son
        çalıştırılan command'in işlemini geri çevirir.*/
        this.undoCommand.undo();
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
