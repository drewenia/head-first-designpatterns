package AdapterAndFacadeDesignPattern.Example04;

public class JsonBankApiAdapter implements BankApi{

    JsonBankApi jsonBankApi;

    public JsonBankApiAdapter(JsonBankApi jsonBankApi) {
        this.jsonBankApi = jsonBankApi;
    }

    @Override
    public boolean executeTransaction(TransferTransaction transferTransaction) {
        /* Business logic burada yer alabilir */
        /* Ben buraya VTS'i gönderirim o hız mı, yön mü, flasor'mu gibi seyleri kendi port eder */
        return jsonBankApi.executeTransaction(transferTransaction);
    }
}
