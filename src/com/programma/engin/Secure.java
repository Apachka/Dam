package com.programma.engin; /**
 * Created by BOBI on 27.11.2016.
 */

import java.math.BigInteger;
import java.security.*;

public class Secure {

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
    public static String getHash(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(message.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString(array[i] & 0xFF));
        }
        return sb.toString();
    }
}

