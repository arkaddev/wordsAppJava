import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

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
        System.out.println("-----------------------------------------");
        return sortedList;
    }

    public static String randomWord(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Lista nie zawiera elementow");
        }

        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index);
    }

    public static List<String> openFileToSave(String nameOfFile) throws FileNotFoundException {
        List<String> statisticsList = new ArrayList<>();

        try {
            File resultsFile = new File(nameOfFile);
            Scanner readResults = new Scanner(resultsFile);
            while (readResults.hasNextLine()) {
                String userData = readResults.nextLine();
                statisticsList.add(userData);
            }
            readResults.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
            throw new FileNotFoundException();
        }
        return statisticsList;
    }

    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        return name;
    }

    public static void saveListToFile(String nameOfFile, List<String> statisticsList) {
        try {
            FileWriter saveFile = new FileWriter(nameOfFile);
            for (int i = 0; i < statisticsList.size(); i++) {
                String name = statisticsList.get(i);
                saveFile.write(name + "\n");
            }

            saveFile.write(Word.results(Word.goodBadAnswers) + "%" + getName() + "@" + getDateAndTime());
            saveFile.close();
            System.out.println("Wynik zostal zapisany");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return simpleDateFormat.format(date);
    }

    public static List<String> chooseFileFromDirectory() {
        List<String> listOfFiles = new ArrayList<>();

        String directoryPath = "words";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (int i = 0; i < files.length; i++) {
                listOfFiles.add(String.valueOf(files[i]));
            }
        }
        return listOfFiles;
    }
}
