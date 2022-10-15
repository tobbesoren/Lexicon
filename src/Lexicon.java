import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lexicon {
    HashMap<String, ArrayList<String>> lexiconMap;
    Scanner input = new Scanner(System.in);
    public Lexicon() {
        this.lexiconMap = new HashMap<>();
    }

    public void addEntry() {
        String englishWord;
        System.out.println("Skriv det svenska ordet:");
        englishWord = input.nextLine();
        if(lexiconMap.containsKey(englishWord)) {
            System.out.println("Skriv den engelska översättningen:");
            lexiconMap.get(englishWord).add(input.nextLine());
        } else {
            System.out.println("Skriv den engelska översättningen:");
            ArrayList<String> translation = new ArrayList<>();
            translation.add(input.nextLine());
            lexiconMap.put(englishWord, translation);
        }
    }

    public void getTranslations() {
        System.out.println("Skriv ett ord på svenska:");
        String word = input.nextLine();
        if(lexiconMap.containsKey(word)) {
            System.out.println("Engelsk översättning:" + lexiconMap.get(word));
        } else {
            System.out.println("Ordet finns inte i lexikonet.");
        }
    }

    public void menu() {
        boolean exit = false;
        do {
            System.out.println("""
                    1. Slå upp ord
                    2. Lägg till översättning
                    3. Avsluta""");

            String selection = input.nextLine();

            switch (selection) {
                case "1" -> getTranslations();
                case "2" -> addEntry();
                case "3" -> exit = true;
                default -> System.out.println("Mata in en siffra mellan 1 och 3, tack.");

            }
        } while(!exit);
    }
}
