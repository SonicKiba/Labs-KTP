import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 2: Проверка пароля ===");
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{8,16}$";

        if (Pattern.matches(regex, password)) {
            System.out.println(" Пароль корректный!");
        } else {
            System.out.println("Пароль не соответствует требованиям!");
        }
    }
}