package generation;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyGeneration {
    public static String getKey () throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[32];
        random.nextBytes(values);

        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String getHmac(String key, String message) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac sha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec s_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256.init(s_key);
        return Base64.encodeBase64String(sha256.doFinal(message.getBytes("UTF-8")));
    }
}
