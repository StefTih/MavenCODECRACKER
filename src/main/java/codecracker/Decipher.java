package codecracker;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a decipher class which uses an encrypted alphabet in order to decrypt hidden messages using
 * encrypted alphabet.
 */
public class Decipher {

    private final HashMap<String, String> cipherAlphabetMapping;

    Decipher() {
        cipherAlphabetMapping = new HashMap();
        MapAlphabetToCipher();
    }

    public void MapAlphabetToCipher() {
        //Old version (you can flex with it but is a bit tedious in the long run)
            /*for( int asciiValue = 97; asciiValue<123; asciiValue++)
            {
                char newChar = (char) asciiValue;
                String character = Character.toString(newChar);
                cipherAlphabetMapping.put(Character.toString(cipher[asciiValue-97]),character);

            }*/
        cipherAlphabetMapping.put("!", "a");
        cipherAlphabetMapping.put(")", "b");
        cipherAlphabetMapping.put(Character.toString('"'), "c");
        cipherAlphabetMapping.put("(", "d");
        cipherAlphabetMapping.put("£", "e");
        cipherAlphabetMapping.put("*", "f");
        cipherAlphabetMapping.put("%", "g");
        cipherAlphabetMapping.put("&", "h");
        cipherAlphabetMapping.put(">", "i");
        cipherAlphabetMapping.put("<", "j");
        cipherAlphabetMapping.put("@", "k");
        cipherAlphabetMapping.put("a", "l");
        cipherAlphabetMapping.put("b", "m");
        cipherAlphabetMapping.put("c", "n");
        cipherAlphabetMapping.put("d", "o");
        cipherAlphabetMapping.put("e", "p");
        cipherAlphabetMapping.put("f", "q");
        cipherAlphabetMapping.put("g", "r");
        cipherAlphabetMapping.put("h", "s");
        cipherAlphabetMapping.put("i", "t");
        cipherAlphabetMapping.put("j", "u");
        cipherAlphabetMapping.put("k", "v");
        cipherAlphabetMapping.put("l", "w");
        cipherAlphabetMapping.put("m", "x");
        cipherAlphabetMapping.put("n", "y");
        cipherAlphabetMapping.put("o", "z");
        cipherAlphabetMapping.put(" ", " ");


    }

    public String decrypt(String newWord) {
        String decryption = "";
        newWord = newWord.toLowerCase().trim();
        if (newWord.length() < 1) {
            return "Please enter a word longer than 0 characters!";
        }
        for (int i = 0; i < newWord.length(); i++) {
            String newLetter = findLetter(i, newWord);
            if (newLetter.equals("Error")) {
                return "This word cannot be translated because the symbol: " + newWord.charAt(i) + " is not part of the encrypted alphabet!";
            }
            decryption = decryption + newLetter;
        }
        return decryption;
    }

    public String findLetter(int index, String newWord) {
        String codedLetter = Character.toString(newWord.charAt(index));
        String letter = cipherAlphabetMapping.get(codedLetter);
        if (letter == null) {
            codedLetter = "Error";
            letter = codedLetter;

        }

        return letter;

    }

    public static void main(String Args[]) {
        while (true) {
            System.out.println("Enter encrypted word:");
            Scanner input = new Scanner(System.in);
            Decipher newWord = new Decipher();
            String decryptedWord = newWord.decrypt(input.nextLine());
            System.out.println("The encrypted code means: " + decryptedWord);
        }

    }
}
