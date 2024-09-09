import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Blowfish {

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
        keyGen.init(64); // This number is how long the generated key will be
        return keyGen.generateKey();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(generateKey());
    }

}
