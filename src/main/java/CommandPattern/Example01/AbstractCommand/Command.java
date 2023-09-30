package CommandPattern.Example01.AbstractCommand;

import java.math.BigDecimal;

public interface Command {
    BigDecimal execute(BigDecimal number1, BigDecimal number2);
}
