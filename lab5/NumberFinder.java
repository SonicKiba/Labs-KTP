import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99. I have 100 apples and 3.14 dollars. Year 2026.";

        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(text);

        System.out.println("=== Задание 1: Поиск всех чисел ===");
        System.out.println("Текст: " + text);
        System.out.println("Найденные числа:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}