import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.SimpleTimeZone;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void splitWord() {
        String input = "yes - tak";

        String[] separatedWord = Word.splitWord(input);

        assertEquals(2, separatedWord.length);

        assertEquals("yes", separatedWord[0]);
        assertEquals("tak", separatedWord[1]);
    }

    @Test
    void scanner() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        InputStream inputStream = new ByteArrayInputStream("tak".getBytes());
        System.setIn(inputStream);

        String output = Word.scanner(inputArray);
        String expectedOutput = "tak";

        assertEquals(expectedOutput, output);
    }
    @Test
    void getPrompt() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        String output = Word.getPrompt(inputArray);
        String expectedOutput = "---";

        assertEquals(expectedOutput, output);
    }
    @Test
    void checkAnswerWhenGoodAnswer() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        String output = Word.checkAnswer(inputArray,"tak");
        String expectedOutput = "ok";

        assertEquals(expectedOutput, output);
        assertEquals(1, Word.goodBadAnswers[0]);
        assertEquals(0, Word.goodBadAnswers[1]);

        Word.goodBadAnswers[0] = 0;
        Word.goodBadAnswers[1] = 0;
    }

    @Test
    void checkAnswerWhenBadAnswer() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        String output = Word.checkAnswer(inputArray,"t");
        String expectedOutput = "zle, poprawna odpowiedz to : " + inputArray[1];

        assertEquals(expectedOutput, output);
        assertEquals(0, Word.goodBadAnswers[0]);
        assertEquals(1, Word.goodBadAnswers[1]);

        Word.goodBadAnswers[0] = 0;
        Word.goodBadAnswers[1] = 0;
    }

    @Test
    void results() {
        int[] goodBadAnswers = new int[2];
        goodBadAnswers[0] = 7;
        goodBadAnswers[1] = 3;

        int output = Word.results(goodBadAnswers);
        int expectedOutput = 70;

        assertEquals(expectedOutput, output);
    }
}