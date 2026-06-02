public class ReverseProcessor {

    @DataProcessor(description = "Переворот текста")
    public String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}