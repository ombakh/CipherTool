public class Vigenere {


    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        int keyLength = key.length();

        for (char c : text.toCharArray()) {
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
        String plaintext = "hello";
        String key = "hi";

        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("PLAINTEXT: " + plaintext);
        System.out.println("KEY: " + key);
        System.out.println("ENCRYPTED: " + encrypted);
        System.out.println("DECRYPTED: " + decrypted);
    }

}