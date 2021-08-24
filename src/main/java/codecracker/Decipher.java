package codecracker;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is a decipher class which uses an encrypted alphabet in order to decrypt hidden messages using
 * encrypted alphabet.
 */
public class Decipher {

    private HashMap<String, String> cipherAlphabetMapping;

//    In order to avoid initialising the HashMap, you can use the double brackets declaration method.
//    All methods must start with a lower case letter.
    Decipher() {
        cipherAlphabetMapping = new HashMap<String,String>() {{
            put("!", "a");
            put(")", "b");
            put("\"", "c");
//            The double quote character has to be escaped with a backslash in a Java string literal. Other characters
//            that need special treatment include:
//            Carriage return and newline: "\r" and "\n"
//            Backslash: "\\\\"
//            Single quote: "\'"
//            Horizontal tab and form feed: "\t" and "\f"
            put("(", "d");
            put("£", "e");
            put("*", "f");
            put("%", "g");
            put("&", "h");
            put(">", "i");
            put("<", "j");
            put("@", "k");
            put("a", "l");
            put("b", "m");
            put("c", "n");
            put("d", "o");
            put("e", "p");
            put("f", "q");
            put("g", "r");
            put("h", "s");
            put("i", "t");
            put("j", "u");
            put("k", "v");
            put("l", "w");
            put("m", "x");
            put("n", "y");
            put("o", "z");
            put(" ", " ");
        }};
    }

//        Another way to do the above is by using a static block.

//        {
//            cipherAlphabetMapping = new HashMap<>();
//        }

//        A class can have any number of static initialization blocks, and they can appear anywhere in the class body.
//        The runtime system guarantees that static initialization blocks are called in the order that they appear
//        in the source code.


//    Един метод или трябва да прави това, което името му казва или да хвърля exception. Нито повече нито по-малко.
    public String decrypt(String newWord) {
        String decryption = "";
        newWord = newWord.toLowerCase().trim();
        try {
            if (newWord.length()<1){
                throw new Exception("Please enter a word!");
            }
            for (int i = 0; i < newWord.length(); i++) {
                String newLetter = findLetter(i, newWord);
                if (newLetter.equals("Error")) {
                    throw new Exception("This value is not within the available symbols in the alphabet!");
                }
                decryption = decryption + newLetter;
            }
        } catch (Exception exception) {
            decryption = exception.getMessage();
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

}
