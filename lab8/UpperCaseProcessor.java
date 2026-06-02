public class UpperCaseProcessor {

    @DataProcessor(description = "Преобразование текста в верхний регистр")
    public String toUpperCase(String text) {
        return text.toUpperCase();
    }
}