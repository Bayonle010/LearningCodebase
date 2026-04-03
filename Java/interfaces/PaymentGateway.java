package Java.interfaces;

public interface PaymentGateway {
    String getProviderName();

    String disburse(String request);
}
