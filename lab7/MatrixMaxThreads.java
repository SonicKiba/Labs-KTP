import java.util.concurrent.*;

public class MatrixMaxThreads {
    public static void main(String[] args) throws Exception {
        // Пример матрицы
        int[][] matrix = {
            {3, 15, 7, 8},
            {8, 2, 20, 4},
            {4, 9, 12, 11},
            {11, 6, 5, 25},
            {7, 14, 18, 9}
        };

        int threadsCount = 3;  // количество потоков
        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        
        @SuppressWarnings("unchecked")
        Future<Integer>[] futures = new Future[threadsCount];

        int rows = matrix.length;
        int partSize = rows / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int startRow = i * partSize;
            int endRow = (i == threadsCount - 1) ? rows : startRow + partSize;

            final int start = startRow;
            final int end = endRow;

            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int r = start; r < end; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        if (matrix[r][c] > max) {
                            max = matrix[r][c];
                        }
                    }
                }
                return max;
            });
        }

        // Находим максимум среди результатов потоков
        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            globalMax = Math.max(globalMax, future.get());
        }

        executor.shutdown();

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}