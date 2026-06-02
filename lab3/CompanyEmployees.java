import java.util.HashMap;

// Класс для управления сотрудниками компании с помощью HashMap
public class CompanyEmployees {

    private HashMap<Integer, Employee> employees;

    public CompanyEmployees() {
        employees = new HashMap<>();
    }

    public void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
        System.out.println("✓ Сотрудник с ID " + id + " добавлен.");
    }

    public Employee getEmployee(int id) {
        Employee emp = employees.get(id);
        if (emp == null) {
            System.out.println("✗ Сотрудник с ID " + id + " не найден.");
        }
        return emp;
    }

    public boolean removeEmployee(int id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("✓ Сотрудник с ID " + id + " удалён.");
            return true;
        } else {
            System.out.println("✗ Сотрудник с ID " + id + " не найден.");
            return false;
        }
    }

    public void printAllEmployees() {
        System.out.println("\n=== Список всех сотрудников компании ===");
        
        if (employees.isEmpty()) {
            System.out.println("В компании пока нет сотрудников.");
            return;
        }

        for (Integer id : employees.keySet()) {
            System.out.println("ID: " + id + " → " + employees.get(id));
        }
        
        System.out.println("Всего сотрудников: " + employees.size());
    }

    public int getCount() {
        return employees.size();
    }
}