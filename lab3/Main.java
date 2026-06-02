public class Main {
    public static void main(String[] args) {

        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА №3 ===\n");

        // ==================== ЗАДАНИЕ 1 ====================
        System.out.println("ЗАДАНИЕ 1: Собственная HashTable\n");

        HashTable<String, Integer> ht = new HashTable<>();

        ht.put("apple", 5);
        ht.put("banana", 3);
        ht.put("orange", 7);
        ht.put("pear", 2);
        ht.put("banana", 10);

        System.out.println(ht);
        System.out.println("Размер таблицы: " + ht.size());
        System.out.println("Значение banana: " + ht.get("banana"));
        System.out.println("Удаляем pear: " + ht.remove("pear"));

        System.out.println("\nПосле удаления:");
        System.out.println(ht);

        // ==================== ЗАДАНИЕ 2 ====================
        System.out.println("\n\nЗАДАНИЕ 2: HashMap с сотрудниками\n");

        CompanyEmployees company = new CompanyEmployees();

        company.addEmployee(1001, new Employee("Иван Иванов", "Программист", 150000));
        company.addEmployee(1002, new Employee("Анна Смирнова", "HR-менеджер", 95000));
        company.addEmployee(1003, new Employee("Петр Петров", "Тестировщик", 120000));
        company.addEmployee(1004, new Employee("Мария Козлова", "Аналитик", 140000));

        company.printAllEmployees();

        System.out.println("\n--- Поиск сотрудника ID 1002 ---");
        Employee found = company.getEmployee(1002);
        if (found != null) {
            System.out.println("Найден: " + found);
        }

        System.out.println("\n--- Удаление сотрудника ID 1003 ---");
        company.removeEmployee(1003);

        company.printAllEmployees();

        System.out.println("\n=== Лабораторная работа выполнена ===");
    }
}