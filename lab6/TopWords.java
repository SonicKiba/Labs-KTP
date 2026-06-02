import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {

    public static void main(String[] args) {
        String filePath = "text.txt";

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Ошибка! Файл " + filePath + " не найден.");
            System.out.println("Создайте файл text.txt в папке с программой.");
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(file, "UTF-8")) {  // ДОБАВИТЬ UTF-8

            int totalWords = 0;

            while (scanner.hasNext()) {
                String word = scanner.next()
                        .toLowerCase()
                        .replaceAll("[^a-zа-яё0-9]", "");

                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    totalWords++;
                }
            }

            System.out.println("Всего обработано слов: " + totalWords);
            System.out.println("Уникальных слов: " + wordCount.size() + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        // Сортировка и вывод топ-10
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("=== ТОП-10 самых частых слов ===\n");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.printf("%d. %-15s - %d раз%n", 
                    i + 1, 
                    list.get(i).getKey(), 
                    list.get(i).getValue());
        }

        if (wordCount.isEmpty()) {
            System.out.println("Файл пустой или не содержит слов.");
        }
    }
}