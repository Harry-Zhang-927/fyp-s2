package com.example.S2.utils;

import javax.crypto.Cipher;
import java.security.*;

public class SecurityUtils {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        return generator.genKeyPair();
    }

    public static byte[] encrypt(PublicKey key, byte[] data) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(PrivateKey key, byte[] data) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] sign(PrivateKey key, byte[] data) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(key);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verify(PublicKey key, byte[] data, byte[] sig) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(key);
        signature.update(data);
        return signature.verify(sig);
    }
}
