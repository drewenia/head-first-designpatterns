package AdapterAndFacadeDesignPattern.Example04;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        /* Aynı nesneyi birden fazla adapter kullanarak ozellestirebiliyorum */
        TransferTransaction transferTransaction =
                new TransferTransaction("12313","1231231", BigDecimal.valueOf(24.5));

        JsonBankApi jsonBankApi = new JsonBankApi();
        JsonBankApiAdapter jsonBankApiAdapter = new JsonBankApiAdapter(jsonBankApi);
        jsonBankApiAdapter.executeTransaction(transferTransaction);

        XmlBankApi xmlBankApi = new XmlBankApi();
        XmlBankApiAdapter xmlBankApiAdapter = new XmlBankApiAdapter(xmlBankApi);
        xmlBankApiAdapter.executeTransaction(transferTransaction);
    }
}
