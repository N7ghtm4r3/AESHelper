package com.tecknobit.aesHelper.CipherHelpers;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

public class CipherHelper {

    public static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final String ALGORITHM_TYPE = "AES";
    private final IvParameterSpec ivParameterSpec;
    private final SecretKey secretKey;
    private final Cipher cipher;

    public CipherHelper(String ivSpec, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.ivParameterSpec = getIvParameter(ivSpec);
        this.secretKey = getSecretKey(secretKey);
        cipher = Cipher.getInstance(ALGORITHM);
    }

    public CipherHelper(IvParameterSpec ivParameterSpec, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.ivParameterSpec = ivParameterSpec;
        this.secretKey = secretKey;
        cipher = Cipher.getInstance(ALGORITHM);
    }

    public String encrypt(String plainMessage) throws IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(ENCRYPT_MODE,secretKey,ivParameterSpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainMessage.getBytes()));
    }

    public String decrypt(String cipheredMessage) throws IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(DECRYPT_MODE,secretKey,ivParameterSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipheredMessage)));
    }

    public String getStringIvParameterSpec(){
        return byteToString(ivParameterSpec.getIV());
    }

    public IvParameterSpec getIvParameterSpec() {
        return ivParameterSpec;
    }

    public String getStringSecretKey(){
        return byteToString(secretKey.getEncoded());
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public static IvParameterSpec getIvParameter(String ivParameter){
        return new IvParameterSpec(stringToBytes(ivParameter));
    }

    public static SecretKey getSecretKey(String secretKey){
        byte[] keyBytes = stringToBytes(secretKey);
        return new SecretKeySpec(keyBytes,0,keyBytes.length,ALGORITHM_TYPE);
    }

    public static byte[] stringToBytes(String sourceString){
        return Base64.getDecoder().decode(sourceString);
    }

    public static String byteToString(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }

}
