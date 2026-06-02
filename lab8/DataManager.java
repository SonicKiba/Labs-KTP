import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private String data = "";

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
        System.out.println("Зарегистрирован процессор: " + processor.getClass().getSimpleName());
    }

    public void loadData(String source) throws IOException {
        data = new String(Files.readAllBytes(Paths.get(source)));
        System.out.println("Загружено из файла: " + source);
        System.out.println("Размер данных: " + data.length() + " символов");
    }

    public void processData() throws Exception {
        System.out.println("\nНачало обработки");

        ExecutorService executor = Executors.newFixedThreadPool(Math.max(2, processors.size()));

        for (Object processor : processors) {
            java.lang.reflect.Method[] methods = processor.getClass().getDeclaredMethods();
            for (java.lang.reflect.Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    DataProcessor ann = method.getAnnotation(DataProcessor.class);
                    System.out.println("Запуск обработчика: " + ann.description());

                    executor.submit(() -> {
                        try {
                            Object result = method.invoke(processor, data);
                            if (result != null) {
                                data = result.toString();
                                System.out.println("✓ " + ann.description() + " выполнен");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка в " + ann.description() + ": " + e.getMessage());
                        }
                    });
                }
            }
        }

        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("=== Обработка завершена ===\n");
    }

    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data.getBytes());
        System.out.println("Данные сохранены в файл: " + destination);
    }

    // Для отладки
    public String getData() {
        return data;
    }
}