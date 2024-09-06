public class Vigenere {


    public static String encrypt(String text, String key) {
        StringBuilder output = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        int keyIndex = 0;
        int keyLength = key.length();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex % keyLength) - 'A';
                char encryptedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                output.append(encryptedChar);
                keyIndex++;

            }
            else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String plaintext = "hello";
        String key = "hi";

        System.out.println("PLAINTEXT: ");
        System.out.println("KEY");
        System.out.println("ENCRYPTED");
    }

}