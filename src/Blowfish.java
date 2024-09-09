import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
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
    public static void main(String[] args) throws Exception {
        System.out.println(generateKey());
    }

}
