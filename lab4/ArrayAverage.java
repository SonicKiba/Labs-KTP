public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int sum = 0;
        int count = 0;

        try {
            System.out.println("Начинаем обработку массива...");

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                count++;
            }

            double average = (double) sum / count;
            System.out.println("Среднее арифметическое = " + average);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ОШИБКА: Выход за границы массива!");
            System.out.println("Сообщение: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка!");
            System.out.println("Сообщение: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: Программа завершила работу с массивом.");
        }
    }
}