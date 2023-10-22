package AdapterAndFacadeDesignPattern.Example04;

public class XmlBankApi implements BankApi{
    public boolean executeTransaction(TransferTransaction transferTransaction) {
        String xml =
                "<Transfer Transaction>" +
                        "\n\t<From IBAN>" + transferTransaction.fromIBAN() + "<From IBAN>" +
                        "\n\t<To IBAN>" + transferTransaction.toIBAN() + "<To IBAN>" +
                        "\n\t<Amount>" + transferTransaction.amount() + "<Amount>" +
                        "\n<Transfer Transaction>";
        System.out.println(xml);
        return true;
    }
}
