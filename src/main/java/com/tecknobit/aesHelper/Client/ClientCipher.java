package com.tecknobit.aesHelper.Client;

import com.tecknobit.aesHelper.Common.CipherHelper;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * The {@code ClientCipher} class is useful for client endpoints to cipher communication
 * @author Tecknobit N7ghtm4r3
 * **/
public class ClientCipher extends CipherHelper {

    /** Constructor to init {@link ClientCipher}
     * @param ivParameterSpec: initialization vector as {@link IvParameterSpec}
     * @param secretKey: secret key used in the {@link Cipher} as {@link SecretKey}
     * **/
    public ClientCipher(IvParameterSpec ivParameterSpec, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        super(ivParameterSpec, secretKey);
    }

    /** Constructor to init {@link CipherHelper}
     * @param ivSpec: initialization vector as {@link String}
     * @param secretKey: secret key used in the {@link Cipher} as {@link String}
     * **/
    public ClientCipher(String ivSpec, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        super(ivSpec, secretKey);
    }

    /**
     * This method is used to encrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param plainMessage: message to cipher
     * @return plain message ciphered as {@link String} es. 26XBx/esnnrehi/GH3tpnQ==
     * **/
    public String encryptRequest(String plainMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.encrypt(plainMessage);
    }

    /**
     * This method is used to decrypt a message with {@link #cipher} instantiated with
     * {@link #ivParameterSpec} and {@link #secretKey} keys.
     * @param cipheredMessage: message to decrypt
     * @return plain message decrypted as {@link String} es. your plain text
     * **/
    public String decryptResponse(String cipheredMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.decrypt(cipheredMessage);
    }

}
