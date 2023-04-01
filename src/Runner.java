import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Runner {
    public static String[] words;
    public static void main(String[] args) {
        words = readFromFile();
        SpellChecker newCheck = new SpellChecker(words);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String word = scanner.nextLine().toLowerCase();

        if (newCheck.checkWord(word)) {
            System.out.println(word + " is correct.");
        }  else {
            String[] results = newCheck.checkWords(word);
            if (results.length == 0) {
                System.out.println("No suggestions for " + word + ".");
            } else {
                System.out.println("Suggestions for " + word + ": ");
                for (String result : results) {
                    System.out.println(result);
                }
            }
        }
    }
    private static String[] readFromFile() {
        String[] words = new String[0];
        try {
            String file = new String(Files.readAllBytes(Paths.get("src/Dictionary.txt")));
            words = file.split("\\s+");
        }catch (IOException e){
            System.out.println("File not found.");
        }
        return words;
    }
}