package com.tecknobit.aesHelper.Exceptions;

public class KeySizeException extends Exception{

    public KeySizeException() {
        super("Key size inserted is not valid, valid values allowed:\n"+
                "-ServerCipher.MINIMUM_KEY_SIZE [128]\n" +
                "-ServerCipher.MEDIUM_KEY_SIZE [192]\n" +
                "-ServerCipher.MAXIMUM_KEY_SIZE [256]\n");
    }

}
