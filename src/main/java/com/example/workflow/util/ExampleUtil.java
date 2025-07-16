package com.example.workflow.util;

import java.security.SecureRandom;
import java.util.Base64;

public class ExampleUtil {
    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().encodeToString(bytes);
    }
}
