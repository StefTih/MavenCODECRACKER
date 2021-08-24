package codecracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Codecracker program.
 */
public class DecipherTest {
    Decipher newWord;

    @BeforeEach
    public void setUp() {
        newWord = new Decipher();
    }

    @Test
    public void normalInput() {
        String decryptedWord = "!£o";
        decryptedWord = newWord.decrypt(decryptedWord);
        Assertions.assertEquals(decryptedWord, "aez");
    }

    @Test
    public void inputWithSpaces() {
        String decryptedWord = "!£ o";
        decryptedWord = newWord.decrypt(decryptedWord);
        Assertions.assertEquals(decryptedWord, "ae z");
    }

    @Test
    public void boundaryTest() {
        String decryptedWord = "!o";
        decryptedWord = newWord.decrypt(decryptedWord);
        Assertions.assertEquals(decryptedWord, "az");
    }

    @Test
    public void invalidInputTest() {
        String decryptedWord = "pp";
        decryptedWord = newWord.decrypt(decryptedWord);
        Assertions.assertEquals(decryptedWord, "This value is not within the available symbols in the alphabet!");
    }

    @Test
    public void blankSpaceTest() {
        String decryptedWord = "";
        decryptedWord = newWord.decrypt(decryptedWord);
        Assertions.assertEquals(decryptedWord, "Please enter a word!");
    }
}
