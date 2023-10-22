package AdapterAndFacadeDesignPattern.Example04;

public class JsonBankApi implements BankApi{
    @Override
    public boolean executeTransaction(TransferTransaction transferTransaction) {
        String json =
                "{\n" +
                        "From IBAN : " + transferTransaction.fromIBAN() +
                        "\nTo IBAN : " + transferTransaction.toIBAN() +
                        "\nAmount : " + transferTransaction.amount() +
                        "\n}";
        System.out.println(json);
        return true;
    }
}
