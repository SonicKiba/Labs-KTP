import java.util.concurrent.*;

public class ArraySumThreads {
    public static void main(String[] args) throws Exception {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int threadsCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        
        @SuppressWarnings("unchecked")
        Future<Integer>[] futures = new Future[threadsCount];

        int partSize = array.length / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int start = i * partSize;
            int end = (i == threadsCount - 1) ? array.length : start + partSize;

            final int startIndex = start;
            final int endIndex = end;

            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    sum += array[j];
                }
                return sum;
            });
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();

        System.out.println("Сумма всех элементов массива: " + totalSum);
    }
}