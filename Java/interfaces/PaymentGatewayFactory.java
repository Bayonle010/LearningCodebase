package Java.interfaces;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaymentGatewayFactory {
    private final Map<String, PaymentGateway> gatewayMap;

    public PaymentGatewayFactory(List<PaymentGateway> gateways) {
        this.gatewayMap = gateways.stream()
                .collect(Collectors.toMap(
                        gateway -> gateway.getProviderName().toUpperCase(),
                        Function.identity()
                ));
    }

    private PaymentGateway getGateway(String provider){
        PaymentGateway gateway = gatewayMap.get(provider.toUpperCase());

        if (gateway == null){
            throw new IllegalArgumentException("unsupported payment provider: " + provider);
        }

        return gateway;
    }
}
