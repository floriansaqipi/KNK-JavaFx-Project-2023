package com.example.knk_project.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {
    private static final int SALT_LENGTH = 32; // length of salt in bytes
    private static final int HASH_LENGTH = 256; // length of hash in bytes
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int ITERATIONS = 10000; // number of iterations for hashing

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generateSaltedHash(String password, String salt) {
        byte[] hash = hashWithSalt(password, salt);
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean compareSaltedHash(String password, String salt, String saltedHash) {
        byte[] expectedHash = Base64.getDecoder().decode(saltedHash);
        byte[] actualHash = hashWithSalt(password, salt);
        return MessageDigest.isEqual(expectedHash, actualHash);
    }

    private static byte[] hashWithSalt(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.reset();
            digest.update(Base64.getDecoder().decode(salt));
            byte[] hash = digest.digest(password.getBytes());

            for (int i = 0; i < ITERATIONS; i++) {
                digest.reset();
                hash = digest.digest(hash);
            }

            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash password: " + e.getMessage(), e);
        }
    }
}
