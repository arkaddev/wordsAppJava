import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFile(String nameOfFile) {

        List<String> listWithWords = new ArrayList<>();

        try {
            File file = new File(nameOfFile); // reading the file
            Scanner readWordFile = new Scanner(file);
            System.out.println("Zaladowano plik: " + nameOfFile);

            while (readWordFile.hasNextLine()) {
                String oneWord = readWordFile.nextLine();
                listWithWords.add(oneWord); // adding to the list
            }

            System.out.println("W pliku znajduje sie: " + listWithWords.size() + " wyrazow");
            readWordFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return listWithWords;
    }

    public static List<String> sortList(List<String> listToSort) {

        List<String> sortedList = new ArrayList<>();

        for (int i = 0; i < listToSort.size(); i++) {
            if (listToSort.get(i).contains("-")) {
                sortedList.add(listToSort.get(i));
            }
        }
        System.out.println("Posortowana lista zawiera: " + sortedList.size() + " wyrazow");
        return sortedList;
    }

    public static String randomWord(List<String> list) {
        if(list.isEmpty()){
            throw new IllegalArgumentException("Lista nie zawiera elementow");
        }

        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index);
    }
}
