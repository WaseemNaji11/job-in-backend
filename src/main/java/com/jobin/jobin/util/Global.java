package com.jobin.jobin.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {
    private static final String secretKey = "6A33617E93E42BFED63A342D5FF4783D";

    public static int userType = 0 ;

    public static String encrypt(String plainText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }


    public static boolean isValidEmail(String email) {
        // Regular expression for a simple email pattern
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        // Compile the pattern
        Pattern pattern = Pattern.compile(emailPattern);
        // Match the email against the pattern
        Matcher matcher = pattern.matcher(email);
        // Check if the email matches the pattern and is not empty
        return matcher.matches() && !email.isEmpty();
    }
}
