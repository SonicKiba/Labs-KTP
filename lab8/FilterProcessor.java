public class FilterProcessor {

    @DataProcessor(description = "Фильтрация строк длиннее 10 символов")
    public String filterLongLines(String text) {
        return Arrays.stream(text.split("\n"))
                     .filter(line -> line.length() > 10)
                     .reduce((a, b) -> a + "\n" + b)
                     .orElse("");
    }
}