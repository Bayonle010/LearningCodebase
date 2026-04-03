package Java.interfaces;

public class PaystackService implements PaymentGateway{
    @Override
    public String getProviderName() {
        return "PAYSTACK";
    }

    @Override
    public String disburse(String request) {
        return "Payment processed with paystack";
    }
}
