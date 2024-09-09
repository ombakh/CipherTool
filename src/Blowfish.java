import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.Base64;

public class Blowfish {

    // generateKey generates a Blowfish key; length based on input value of keyGen.init(#)
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
        keyGen.init(64); // This number is how long the generated key will be
        return keyGen.generateKey();
    }

    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key); // This sets the Cipher to encrypt mode

        //plaintext -> Base64 String
        byte[] encryptedBites = cipher.doFinal(plaintext.getBytes("UTF-8")); // -> defines text standard
        return Base64.getEncoder().encodeToString(encryptedBites); // -> puts encrypted bites into string

    }

    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);

        //plaintext -> Base64 again
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8"); // returns final text

    }
    public static void main(String[] args) throws Exception {
        //generates a key
        SecretKey secretKey = generateKey();

        String plaintext = "This is going to be encrypted with Blowfish!";
        String cipher = encrypt(plaintext, secretKey);
        String decipher = decrypt(plaintext, secretKey);

        System.out.println("PLAINTEXT: " + plaintext);
        System.out.println("ENCRYPTED TEXT: " + cipher);
        System.out.println("DECRYPTED TEXT: " + decipher);
    }

}
