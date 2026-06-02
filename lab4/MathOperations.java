// MathOperations.java
public class MathOperations {

    public static double calculate(double a, double b, String operation) 
            throws CustomUnsupportedOperationException {

        switch (operation.toLowerCase()) {
            case "+":
            case "add":
                return a + b;

            case "-":
            case "subtract":
                return a - b;

            case "*":
            case "multiply":
                return a * b;

            case "/":
            case "divide":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно!");
                }
                return a / b;

            default:
                throw new CustomUnsupportedOperationException(
                    "Операция '" + operation + "' не поддерживается. " +
                    "Поддерживаемые операции: +, -, *, /"
                );
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Математические операции ===\n");

        try {
            System.out.println("5 + 3 = " + calculate(5, 3, "+"));
            System.out.println("10 - 4 = " + calculate(10, 4, "-"));
            System.out.println("6 * 7 = " + calculate(6, 7, "*"));
            System.out.println("20 / 5 = " + calculate(20, 5, "/"));

            System.out.println("\nПопытка выполнить неподдерживаемую операцию:");
            System.out.println(calculate(10, 2, "%"));

        } catch (CustomUnsupportedOperationException e) {
            System.out.println("Поймано кастомное исключение:");
            System.out.println(e.getMessage());
            
            ExceptionLogger.logException(e, "MathOperations", "Неподдерживаемая математическая операция");

        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка: " + e.getMessage());
            ExceptionLogger.logException(e, "MathOperations", "Ошибка деления");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e, "MathOperations", null);
        }
    }
}