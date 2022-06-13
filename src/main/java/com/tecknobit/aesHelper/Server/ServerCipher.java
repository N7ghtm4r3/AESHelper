package com.tecknobit.aesHelper.Server;

import com.tecknobit.aesHelper.Common.CipherHelper;
import com.tecknobit.aesHelper.Exceptions.KeySizeException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * The {@code ClientCipher} class is useful for server endpoints to cipher communication
 * @author Tecknobit N7ghtm4r3
 * **/
public class ServerCipher extends CipherHelper {

    /**
     * {@code MINIMUM_KEY_SIZE} is instance that memorize minimum key size to generate a {@link SecretKey}
     * **/
    public static final int MINIMUM_KEY_SIZE = 128;

    /**
     * {@code MEDIUM_KEY_SIZE} is instance that memorize medium key size to generate a {@link SecretKey}
     * **/
    public static final int MEDIUM_KEY_SIZE = 192;

    /**
     * {@code MAXIMUM_KEY_SIZE} is instance that memorize maximum key size to generate a {@link SecretKey}
     * **/
    public static final int MAXIMUM_KEY_SIZE = 256;

    /**
     * {@code keySize} is instance that memorize key size used in this communication session
     * **/
    private final int keySize;

    /** Constructor to init {@link ServerCipher}
     * @param ivParameterSpec: initialization vector as {@link IvParameterSpec}
     * @param secretKey: secret key used in the {@link Cipher} as {@link SecretKey}
     * **/
    public ServerCipher(IvParameterSpec ivParameterSpec, SecretKey secretKey, int keySize) throws NoSuchPaddingException,
            NoSuchAlgorithmException, KeySizeException {
        super(ivParameterSpec, secretKey);
        if(keySize == MINIMUM_KEY_SIZE || keySize == MEDIUM_KEY_SIZE || keySize == MAXIMUM_KEY_SIZE)
            this.keySize = keySize;
        else
            throw new KeySizeException();
    }

    /** Constructor to init {@link ServerCipher}
     * @param ivSpec: initialization vector as {@link String}
     * @param secretKey: secret key used in the {@link Cipher} as {@link String}
     * **/
    public ServerCipher(String ivSpec, String secretKey, int keySize) throws NoSuchPaddingException,
            NoSuchAlgorithmException, KeySizeException {
        super(ivSpec,secretKey);
        if(keySize == MINIMUM_KEY_SIZE || keySize == MEDIUM_KEY_SIZE || keySize == MAXIMUM_KEY_SIZE)
            this.keySize = keySize;
        else
            throw new KeySizeException();
    }

    /**
     * This method is used to decrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param cipheredMessage: message to decrypt
     * @return plain message decrypted as {@link String} es. your plain text
     * **/
    public String decryptRequest(String cipheredMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.decrypt(cipheredMessage);
    }

    /**
     * This method is used to encrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param plainMessage: message to cipher
     * @return plain message ciphered as {@link String} es. 26XBx/esnnrehi/GH3tpnQ==
     * **/
    public String encryptResponse(String plainMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.encrypt(plainMessage);
    }

    /**
     * This method is used to generate an initialization vector <br>
     * Any params required
     * @return initialization vector as {@link IvParameterSpec}
     * **/
    public static IvParameterSpec generateIvParameterSpec() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    /**
     * This method is used to generate an initialization vector <br>
     * Any params required
     * @return initialization vector as {@link String}
     * **/
    public static String generateIvParameterSpecString(){
        return byteToString(generateIvParameterSpec().getIV());
    }

    /**
     * This method is used to generate a secret key
     * @param keySize: size for secret key
     * @implNote sizes admitted are {@link #MINIMUM_KEY_SIZE}, {@link #MEDIUM_KEY_SIZE} or {@link #MAXIMUM_KEY_SIZE}
     * @return secret key as {@link SecretKey}
     * **/
    public static SecretKey generateSecretKey(int keySize) throws NoSuchAlgorithmException, KeySizeException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_TYPE);
         if(keySize == MINIMUM_KEY_SIZE || keySize == MEDIUM_KEY_SIZE || keySize == MAXIMUM_KEY_SIZE){
            keyGenerator.init(keySize);
            return keyGenerator.generateKey();
         }else
            throw new KeySizeException();
    }

    /**
     * This method is used to generate a secret key
     * @param keySize: size for secret key
     * @implNote sizes admitted are {@link #MINIMUM_KEY_SIZE}, {@link #MEDIUM_KEY_SIZE} or {@link #MAXIMUM_KEY_SIZE}
     * @return secret key as {@link String}
     * **/
    public static String generateSecretKeyString(int keySize) throws NoSuchAlgorithmException, KeySizeException {
        return byteToString(generateSecretKey(keySize).getEncoded());
    }

    public int getKeySize() {
        return keySize;
    }

}
