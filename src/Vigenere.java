public class Vigenere {

    //encrypt method
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        int keyLength = key.length();
        //takes string and puts it in an array
        for (char c : text.toCharArray()) {
            //shifts character x amount of spaces based on the key
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex % keyLength) - 'A';
                char encryptedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                result.append(encryptedChar);
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    //opposite of encrypt function based on key
    public static String decrypt(String plaintext, String key) {
        StringBuilder result = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        int keyLength = key.length();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex % keyLength) - 'A';
                char decryptedChar = (char) (((c - 'A' - shift + 26) % 26) + 'A');
                result.append(decryptedChar);
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        String key = "bananas";
        // declares encrypted and decrypted values in main method
        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);
        //prints final output
        System.out.println("PLAINTEXT: " + plaintext);
        System.out.println("KEY: " + key);
        System.out.println("ENCRYPTED: " + encrypted);
        System.out.println("DECRYPTED: " + decrypted);
    }

}