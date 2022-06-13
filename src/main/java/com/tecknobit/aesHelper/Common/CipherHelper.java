package com.tecknobit.aesHelper.Common;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static java.util.Base64.getDecoder;
import static java.util.Base64.getEncoder;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

/**
 * The {@code CipherHelper} class is useful for client and server endpoints to cipher communication
 * @author Tecknobit N7ghtm4r3
 * **/
public class CipherHelper {

    /**
     * {@code ALGORITHM} is instance that memorize algorithm used for the {@link #cipher}
     * **/
    public static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * {@code ALGORITHM_TYPE} is instance that memorize algorithm type used for the {@link #cipher}
     * **/
    public static final String ALGORITHM_TYPE = "AES";

    /**
     * {@code ivParameterSpec} is instance that memorize initialization vector used for the {@link #cipher}
     * **/
    protected final IvParameterSpec ivParameterSpec;

    /**
     * {@code secretKey} is instance that memorize secret key used for the {@link #cipher}
     * **/
    protected final SecretKey secretKey;

    /**
     * {@code cipher} is instance that memorize {@link Cipher} object
     * **/
    protected final Cipher cipher;

    /** Constructor to init {@link CipherHelper}
     * @param ivParameterSpec: initialization vector as {@link IvParameterSpec}
     * @param secretKey: secret key used in the {@link Cipher} as {@link SecretKey}
     * **/
    public CipherHelper(IvParameterSpec ivParameterSpec, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.ivParameterSpec = ivParameterSpec;
        this.secretKey = secretKey;
        cipher = Cipher.getInstance(ALGORITHM);
    }

    /** Constructor to init {@link CipherHelper}
     * @param ivSpec: initialization vector as {@link String}
     * @param secretKey: secret key used in the {@link Cipher} as {@link String}
     * **/
    public CipherHelper(String ivSpec, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.ivParameterSpec = getIvParameter(ivSpec);
        this.secretKey = getSecretKey(secretKey);
        cipher = Cipher.getInstance(ALGORITHM);
    }

    /**
     * This method is used to encrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param plainMessage: message to cipher
     * @return plain message ciphered as {@link String} es. 26XBx/esnnrehi/GH3tpnQ==
     * **/
    public String encrypt(String plainMessage) throws IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(ENCRYPT_MODE,secretKey,ivParameterSpec);
        return getEncoder().encodeToString(cipher.doFinal(plainMessage.getBytes()));
    }

    /**
     * This method is used to decrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param cipheredMessage: message to decrypt
     * @return plain message decrypted as {@link String} es. your plain text
     * **/
    public String decrypt(String cipheredMessage) throws IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(DECRYPT_MODE,secretKey,ivParameterSpec);
        return new String(cipher.doFinal(getDecoder().decode(cipheredMessage)));
    }

    public IvParameterSpec getIvParameterSpec() {
        return ivParameterSpec;
    }

    /**
     * This method is used to get {@link #ivParameterSpec} instance as {@link String} <br>
     * Any params required
     * @return {@link #ivParameterSpec} instance as {@link String}
     * **/
    public String getStringIvParameterSpec(){
        return byteToString(ivParameterSpec.getIV());
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    /**
     * This method is used to get {@link #secretKey} instance as {@link String} <br>
     * Any params required
     * @return {@link #secretKey} instance as {@link String}
     * **/
    public String getStringSecretKey(){
        return byteToString(secretKey.getEncoded());
    }

    public Cipher getCipher() {
        return cipher;
    }

    /**
     * This method is used to assemble an initialization vector from a {@link String} object
     * @param ivParameter: initialization vector as {@link String}
     * @return initialization vector as {@link IvParameterSpec}
     * **/
    public static IvParameterSpec getIvParameter(String ivParameter){
        return new IvParameterSpec(stringToBytes(ivParameter));
    }

    /**
     * This method is used to assemble a secret key from a {@link String} object
     * @param secretKey: secret key as {@link String}
     * @return secret key as {@link SecretKey}
     * **/
    public static SecretKey getSecretKey(String secretKey){
        byte[] keyBytes = stringToBytes(secretKey);
        return new SecretKeySpec(keyBytes,0,keyBytes.length,ALGORITHM_TYPE);
    }

    /**
     * This method is used to obtain a byte array from a {@link Base64} {@link String}
     * @param sourceString: source to get byte
     * @return byte array
     * **/
    public static byte[] stringToBytes(String sourceString){
        return getDecoder().decode(sourceString);
    }

    /**
     * This method is used to obtain a {@link String} from a {@link Base64} byte array
     * @param bytes: source to get string
     * @return string as {@link String}
     * **/
    public static String byteToString(byte[] bytes){
        return getEncoder().encodeToString(bytes);
    }

}
