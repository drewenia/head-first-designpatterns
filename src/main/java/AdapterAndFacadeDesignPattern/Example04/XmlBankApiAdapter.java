package AdapterAndFacadeDesignPattern.Example04;

public class XmlBankApiAdapter implements BankApi{
    XmlBankApi xmlBankApi;

    public XmlBankApiAdapter(XmlBankApi xmlBankApi) {
        this.xmlBankApi = xmlBankApi;
    }

    @Override
    public boolean executeTransaction(TransferTransaction transferTransaction) {
        /* Business logic burada yer alabilir */
        /* Ben buraya VTS'i gönderirim o hız mı, yön mü, flasor'mu gibi seyleri kendi port eder */
        return xmlBankApi.executeTransaction(transferTransaction);
    }
}
