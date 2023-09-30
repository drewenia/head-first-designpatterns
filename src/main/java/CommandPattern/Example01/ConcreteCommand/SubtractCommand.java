package CommandPattern.Example01.ConcreteCommand;

import CommandPattern.Example01.AbstractCommand.Command;

import java.math.BigDecimal;

public class SubtractCommand implements Command {
    @Override
    public BigDecimal execute(BigDecimal number1, BigDecimal number2) {
        return number1.subtract(number2);
    }
}
