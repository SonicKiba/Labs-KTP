import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            DataManager manager = new DataManager();

            // Регистрация процессоров
            manager.registerDataProcessor(new UpperCaseProcessor());
            manager.registerDataProcessor(new ReverseProcessor());
            manager.registerDataProcessor(new FilterProcessor());

            // Загрузка данных
            manager.loadData("input.txt");

            // Обработка
            manager.processData();

            // Сохранение результата
            manager.saveData("output.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}