package Java;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class GenerateNombaSignature {
    public static void main(String[] args) throws Exception {

        // ── Exact values from your Postman body ──────────────────────────────
        String eventType       = "payout_success";
        String requestId       = "45f2dc2d-d559-4773-bba3-2XXXXXXXXXX";
        String userId          = "b7b10e81-xx-xx-xx-f4e23a132bbf";
        String walletId        = "6756ff80aafe04aXXXXXXXXXX";
        String transactionId   = "API-VACT_TRA-B7B10-0435b274-807a-4bc7-8XXXXXXXXXX";
        String transactionType = "vact_transfer";
        String transactionTime = "2025-09-29T10:51:44Z";
        String responseCode    = "";

        // ── Must match nomba-timestamp header you put in Postman ─────────────
        String timestamp       = "2025-09-29T10:51:44Z"; // use any RFC-3339 value, but keep it consistent

        // ── Your webhook secret ──────────────────────────────────────────────
        String secret          = "1ALcOI7ONW7fnmQpVvodr+CL4GuOUPvJubgvussP+bM=";

        String signingPayload = String.join(":",
                eventType, requestId, userId, walletId,
                transactionId, transactionType, transactionTime,
                responseCode, timestamp);

        System.out.println("Signing payload: [" + signingPayload + "]");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] hash = mac.doFinal(signingPayload.getBytes(StandardCharsets.UTF_8));
        String signature = Base64.getEncoder().encodeToString(hash);

        System.out.println("Signature: " + signature);
    }
}