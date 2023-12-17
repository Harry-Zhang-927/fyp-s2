package com.example.S2.utils;

import java.security.SecureRandom;

public class PseudorandomSequenceUtil {
    public static byte[] generateSequence(int length) {
        SecureRandom random = new SecureRandom();
        byte[] sequence = new byte[length];
        random.nextBytes(sequence);
        return sequence;
    }
}
