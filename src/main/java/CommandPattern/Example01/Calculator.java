package CommandPattern.Example01;

import CommandPattern.Example01.AbstractCommand.Command;

import java.math.BigDecimal;

public class Calculator {
    public static BigDecimal operation(Command command, BigDecimal number1, BigDecimal number2) {
        return command.execute(number1,number2);
    }
}
