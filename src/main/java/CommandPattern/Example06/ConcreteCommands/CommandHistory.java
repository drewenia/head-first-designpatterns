package CommandPattern.Example06.ConcreteCommands;

import CommandPattern.Example06.AbstractBaseCommand.Command;

import java.util.Stack;

public class CommandHistory {
    private final Stack<Command> history = new Stack<>();

    public void push(Command command){
        history.push(command);
    }

    public Command pop(){
        return history.pop();
    }

    public boolean isEmpty(){
        return history.isEmpty();
    }
}
