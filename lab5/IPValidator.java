import java.util.Scanner;
import java.util.regex.*;

public class IPValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 4: Проверка IP-адреса ===");
        System.out.print("Введите IP-адрес: ");
        String ip = scanner.nextLine().trim();

        String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        if (Pattern.matches(regex, ip)) {
            System.out.println("IP-адрес корректный!");
        } else {
            System.out.println("IP-адрес некорректный!");
        }
        
        scanner.close();
    }
}