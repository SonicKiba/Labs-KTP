import java.util.Scanner;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "Apple banana Cherry apple pie Java javascript Python";

        System.out.println("=== Задание 5: Поиск слов по первой букве ===");
        System.out.print("Введите букву: ");
        String letter = scanner.nextLine().trim();

        if (letter.length() != 1) {
            System.out.println("Ошибка! Нужно ввести одну букву.");
            return;
        }

        String regex = "\\b" + letter + "\\w*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся на '" + letter + "':");
        boolean found = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Таких слов не найдено.");
        }
    }
}