package AdapterAndFacadeDesignPattern.Example04;

import java.math.BigDecimal;

public record TransferTransaction(String fromIBAN, String toIBAN, BigDecimal amount) {
}
