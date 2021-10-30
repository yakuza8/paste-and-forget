package com.yakuza.pasteandforget.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

import static com.yakuza.pasteandforget.PasteConstants.MAX_SHORTLINK_LENGTH;

public class ShortlinkGenerator {
    private final static String MD_ALGORITHM = "MD5";
    private static Logger logger = LoggerFactory.getLogger(ShortlinkGenerator.class);

    public static String generateShortlink() {
        // Get random seed as time
        Instant seed = Instant.now();
        // But also add another randomness as applicable
        UUID uuid = UUID.randomUUID();
        // Combine them to be digested by md5 and then base64
        String shortlinkHash = uuid.toString() + seed;
        String hash = base64(md5(shortlinkHash));
        return hash.substring(0, MAX_SHORTLINK_LENGTH > hash.length() ? hash.length() : MAX_SHORTLINK_LENGTH);
    }

    private static String md5(String shortlinkHash) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD_ALGORITHM);
            md.update(shortlinkHash.getBytes(), 0, shortlinkHash.length());
            shortlinkHash = new BigInteger(1, md.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error("No such algorithm found as " + MD_ALGORITHM);
        }
        return shortlinkHash;
    }

    private static String base64(String shortlinkHash) {
        return Base64.getUrlEncoder().encodeToString(shortlinkHash.getBytes());
    }
}
