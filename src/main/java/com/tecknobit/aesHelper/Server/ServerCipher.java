package com.tecknobit.aesHelper.Server;

import com.tecknobit.aesCipher.CipherHelpers.CipherHelper;
import com.tecknobit.aesCipher.Exceptions.KeySizeException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class ServerCipher extends CipherHelper {

    public static final int MINIMUM_KEY_SIZE = 128;
    public static final int MEDIUM_KEY_SIZE = 192;
    public static final int MAXIMUM_KEY_SIZE = 256;
    private final int keySize;

    public ServerCipher(String ivSpec, String secretKey, int keySize) throws NoSuchPaddingException,
            NoSuchAlgorithmException, KeySizeException {
        super(ivSpec,secretKey);
        if(keySize == MINIMUM_KEY_SIZE || keySize == MEDIUM_KEY_SIZE || keySize == MAXIMUM_KEY_SIZE)
            this.keySize = keySize;
        else
            throw new KeySizeException();
    }

    public ServerCipher(IvParameterSpec ivParameterSpec, SecretKey secretKey, int keySize) throws NoSuchPaddingException,
            NoSuchAlgorithmException, KeySizeException {
        super(ivParameterSpec, secretKey);
        if(keySize == MINIMUM_KEY_SIZE || keySize == MEDIUM_KEY_SIZE || keySize == MAXIMUM_KEY_SIZE)
            this.keySize = keySize;
        else
            throw new KeySizeException();
    }

    public String decryptRequest(String cipheredMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.decrypt(cipheredMessage);
    }

    public String encryptResponse(String plainMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.encrypt(plainMessage);
    }

    public IvParameterSpec generateIvParameterSpec() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_TYPE);
        keyGenerator.init(keySize);
        return keyGenerator.generateKey();
    }

    public int getKeySize() {
        return keySize;
    }

}
