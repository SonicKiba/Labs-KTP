import java.io.*;
import java.time.LocalDateTime;

public class ExceptionLogger {

    private static final String LOG_FILE = "exceptions.log";

    public static void logException(Exception e, String className, String additionalInfo) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("=== " + LocalDateTime.now() + " ===");
            bw.newLine();
            bw.write("Класс: " + className);
            bw.newLine();
            bw.write("Тип исключения: " + e.getClass().getSimpleName());
            bw.newLine();
            bw.write("Сообщение: " + e.getMessage());
            bw.newLine();
            
            if (additionalInfo != null && !additionalInfo.isEmpty()) {
                bw.write("Дополнительная информация: " + additionalInfo);
                bw.newLine();
            }
            
            bw.write("StackTrace: " + e.toString());
            bw.newLine();
            bw.write("----------------------------------------");
            bw.newLine();
            
            System.out.println(" Исключение залогировано в файл: " + LOG_FILE);

        } catch (IOException ex) {
            System.err.println("Не удалось записать лог: " + ex.getMessage());
        }
    }
}