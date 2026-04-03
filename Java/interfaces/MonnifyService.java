package Java.interfaces;


public class MonnifyService implements  PaymentGateway{
    @Override
    public String getProviderName() {
        return "MONNIFY";
    }

    @Override
    public String disburse(String request) {
        return "Payment processed with monnify";
    }
}
