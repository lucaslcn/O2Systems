/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gema;

/**
 *
 * @author Lucas
 */
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EncryptDecryptStringWithDES {

    public Cipher ecipher;
    public Cipher dcipher;
    public SecretKey key;

    /**
     *
     */
    public EncryptDecryptStringWithDES() {

        try {


            // generate secret key using DES algorithm
            key = KeyGenerator.getInstance("DES").generateKey();

            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            // initialize the ciphers with the given key
            ecipher.init(Cipher.ENCRYPT_MODE, key);

            dcipher.init(Cipher.DECRYPT_MODE, key);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
            return;
        }

    }

    public Cipher getEcipher() {
        return ecipher;
    }

    public void setEcipher(Cipher ecipher) {
        this.ecipher = ecipher;
    }

    public Cipher getDcipher() {
        return dcipher;
    }

    public void setDcipher(Cipher dcipher) {
        this.dcipher = dcipher;
    }

    public SecretKey getKey() {
        return key;
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }

  

    public static String encrypt(String str, Cipher ecipher) {

        try {

            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array. 
            byte[] utf8 = str.getBytes("UTF8");

            byte[] enc = ecipher.doFinal(utf8);

// encode to base64
            enc = BASE64EncoderStream.encode(enc);

            return new String(enc);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public static String decrypt(String str, Cipher dcipher) {

        try {

            // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());

            byte[] utf8 = dcipher.doFinal(dec);

// create new string based on the specified charset
            return new String(utf8, "UTF8");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

}
