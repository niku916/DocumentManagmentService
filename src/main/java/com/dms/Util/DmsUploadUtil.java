package com.dms.Util;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Component
public class DmsUploadUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DmsUploadUtil.class);

    private static final String ALGORITHM = "AES"; // or "DESede" etc. depending on original

    public static String decrypt(String encryptedText, String key) {
        try {
            byte[] cipheredBytes = Base64.decodeBase64(encryptedText);
            byte[] keyBytes = getKeyBytes(key);

            byte[] decryptedBytes = decrypt(cipheredBytes, keyBytes, keyBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);

        } catch (Exception e) {
            LOGGER.error("Error decrypting data", e);
            return null;
        }
    }

    private static byte[] decrypt(byte[] cipheredBytes, byte[] keyBytes, byte[] ivBytes) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(cipheredBytes);
    }

    private static byte[] getKeyBytes(String key) throws Exception {
        // Example: pad or trim to 16 bytes for AES-128
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes = key.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }

}
