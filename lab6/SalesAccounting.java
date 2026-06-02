import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class SalesAccounting {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> sales = new ConcurrentHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Программа учёта продаж в магазине ===\n");

        while (true) {
            System.out.println("1. Добавить продажу");
            System.out.println("2. Показать все продажи");
            System.out.println("3. Общая сумма продаж");
            System.out.println("4. Самый популярный товар");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
            } catch (Exception e) {
                System.out.println("Введите число!\n");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите название товара: ");
                    String product = scanner.nextLine().trim();

                    System.out.print("Введите количество проданных единиц: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    if (quantity > 0) {
                        sales.put(product, sales.getOrDefault(product, 0) + quantity);
                        System.out.println("Продажа добавлена!\n");
                    } else {
                        System.out.println("Количество должно быть больше 0!\n");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Список проданных товаров ---");
                    if (sales.isEmpty()) {
                        System.out.println("Пока нет продаж.");
                    } else {
                        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                            System.out.println(entry.getKey() + " — " + entry.getValue() + " шт.");
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    int total = 0;
                    for (int qty : sales.values()) {
                        total += qty;
                    }
                    System.out.println("\nОбщее количество проданных товаров: " + total + " шт.\n");
                    break;

                case 4:
                    if (sales.isEmpty()) {
                        System.out.println("\nПока нет продаж.\n");
                    } else {
                        String bestProduct = null;
                        int maxSales = 0;

                        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
                            if (entry.getValue() > maxSales) {
                                maxSales = entry.getValue();
                                bestProduct = entry.getKey();
                            }
                        }
                        System.out.println("\nСамый популярный товар: " + bestProduct 
                                        + " (" + maxSales + " шт.)\n");
                    }
                    break;

                case 0:
                    System.out.println("\nПрограмма завершена. До свидания!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор!\n");
            }
        }
    }
}