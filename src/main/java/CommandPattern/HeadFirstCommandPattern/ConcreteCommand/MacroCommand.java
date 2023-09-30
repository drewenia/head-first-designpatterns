package CommandPattern.HeadFirstCommandPattern.ConcreteCommand;

import CommandPattern.HeadFirstCommandPattern.Command.Command;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        /* Commands array'ini alın ve bunları MacroCommand içinde saklayın */
        this.commands = commands;
    }

    @Override
    public void execute() {
        /* Macro, uzaktan kumanda tarafından çalıştırıldığında, bu command'leri sırayla çalıştırır.*/
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for(Command command : commands){
            command.undo();
        }
    }
}
