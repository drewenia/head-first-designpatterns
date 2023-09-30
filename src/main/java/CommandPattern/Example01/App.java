package CommandPattern.Example01;

import CommandPattern.Example01.AbstractCommand.Command;
import CommandPattern.Example01.ConcreteCommand.AddCommand;
import CommandPattern.Example01.ConcreteCommand.SubtractCommand;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Command addCommand = new AddCommand();
        Command subtractCommand = new SubtractCommand();

        BigDecimal add = Calculator.operation(addCommand, BigDecimal.valueOf(4), BigDecimal.valueOf(4));
        BigDecimal subtraction = Calculator.operation(subtractCommand, BigDecimal.valueOf(3), BigDecimal.valueOf(1));
        System.out.println(add);
        System.out.println(subtraction);
    }
}
