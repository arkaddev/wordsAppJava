import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileReaderTest {

    @Test
    void readFile() {
        String path = "src/test/java/ReadFileTest";
        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        FileReader fileReader = new FileReader();
        List<String> outputList = new ArrayList<>();
        outputList = FileReader.readFile(path);


        Assertions.assertEquals(expectedList, outputList);
    }

    @Test
    void sortList() {
        List<String> list = Arrays.asList(
                "yes - tak",
                "where - gdzie",
                "A",
                "empty",
                "12345"
        );

        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        List<String> outputList = new ArrayList<>();
        outputList = FileReader.sortList(list);

        Assertions.assertEquals(expectedList, outputList);
    }

    @Test
    void randomWord() {
        List<String> list = Arrays.asList(
                "element",
                "element2",
                "element3"
        );

        String word = FileReader.randomWord(list);

        Assertions.assertTrue(list.contains(word));
    }

    @Test
    void randomWordWithEmptyList() {
        final List<String> list = Arrays.asList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> FileReader.randomWord(list));
    }
}