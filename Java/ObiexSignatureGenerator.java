package Java;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.HexFormat;
import java.util.Locale;

public final class ObiexSignatureGenerator {

    private static final String HMAC_SHA256 = "HmacSHA256";

    private ObiexSignatureGenerator() {
    }

    public static void main(String[] args) {

        // Loads the .env file from the project root
//        Dotenv dotenv = Dotenv.configure()
//                .directory("./")
//                .load();

        String secretKey = "2650364fd5004ec88c56aa679884ba9b";

        ObiexSignature result = generate(
                "GET",
                "/v1/addresses/me/broker",
                secretKey
        );

        System.out.println(
                "Content to sign: " + result.contentToSign()
        );

        System.out.println(
                "X-API-TIMESTAMP: " + result.timestamp()
        );

        System.out.println(
                "X-API-SIGNATURE: " + result.signature()
        );
    }

    public static ObiexSignature generate(
            String httpMethod,
            String requestPath,
            String secretKey
    ) {
        if (httpMethod == null || httpMethod.isBlank()) {
            throw new IllegalArgumentException(
                    "HTTP method is required"
            );
        }

        if (requestPath == null || requestPath.isBlank()) {
            throw new IllegalArgumentException(
                    "Request path is required"
            );
        }

        if (secretKey == null || secretKey.isBlank()) {
            throw new IllegalArgumentException(
                    "OBIEX_SECRET_KEY was not found in the .env file"
            );
        }

        String method = httpMethod
                .trim()
                .toUpperCase(Locale.ROOT);

        String path = requestPath.startsWith("/")
                ? requestPath
                : "/" + requestPath;

        String timestamp = Long.toString(
                Instant.now().toEpochMilli()
        );

        String contentToSign =
                method
                        + path
                        + timestamp;

        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);

            SecretKeySpec secretKeySpec = new SecretKeySpec(
                    secretKey.getBytes(StandardCharsets.UTF_8),
                    HMAC_SHA256
            );

            mac.init(secretKeySpec);

            byte[] signatureBytes = mac.doFinal(
                    contentToSign.getBytes(StandardCharsets.UTF_8)
            );

            String signature = HexFormat.of()
                    .formatHex(signatureBytes);

            return new ObiexSignature(
                    timestamp,
                    signature,
                    contentToSign
            );

        } catch (GeneralSecurityException exception) {
            throw new IllegalStateException(
                    "Failed to generate ObiEx API signature",
                    exception
            );
        }
    }

    public record ObiexSignature(
            String timestamp,
            String signature,
            String contentToSign
    ) {
    }
}