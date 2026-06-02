import java.util.regex.*;

public class CaseFinder {
    public static void main(String[] args) {
        String text = "HelloWorld thisIsTest javaScript isFun camelCase";

        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        String result = text;

        System.out.println("=== Задание 3: Поиск заглавной после строчной ===");
        System.out.println("Оригинал: " + text);
        System.out.println("Результат:");

        while (matcher.find()) {
            String found = matcher.group();
            String highlighted = "!" + found + "!";
            result = result.replaceFirst(found, highlighted);
        }

        System.out.println(result);
    }
}