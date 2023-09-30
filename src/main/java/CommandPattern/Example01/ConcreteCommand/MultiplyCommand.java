package CommandPattern.Example01.ConcreteCommand;

import CommandPattern.Example01.AbstractCommand.Command;

import java.math.BigDecimal;

public class MultiplyCommand implements Command {
    @Override
    public BigDecimal execute(BigDecimal number1, BigDecimal number2) {
        return number1.multiply(number2);
    }
}
