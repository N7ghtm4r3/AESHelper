package com.tecknobit.aesHelper.Client;

import com.tecknobit.aesHelper.CipherHelpers.CipherHelper;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ClientCipher extends CipherHelper {

    public ClientCipher(String ivSpec, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        super(ivSpec, secretKey);
    }

    public ClientCipher(IvParameterSpec ivParameterSpec, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        super(ivParameterSpec, secretKey);
    }

    public String encryptRequest(String plainMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.encrypt(plainMessage);
    }

    public String decryptResponse(String cipheredMessage) throws InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return super.decrypt(cipheredMessage);
    }

}
