import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован!");

        } catch (FileNotFoundException e) {
            System.out.println("ОШИБКА: Файл не найден! Проверьте имя файла.");
        } catch (IOException e) {
            System.out.println("ОШИБКА при чтении/записи файла!");
            System.out.println("Сообщение: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        } finally {
            System.out.println("Операция копирования завершена.");
        }
    }
}