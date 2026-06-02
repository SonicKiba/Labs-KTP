import java.util.concurrent.*;

public class Warehouse {
    public static void main(String[] args) {
        int[] goods = {30, 45, 25, 40, 35, 20, 50, 15, 55, 10};
        int maxWeight = 150;

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            executor.execute(new Loader("Грузчик " + i, goods, maxWeight, latch));
        }

        try {
            latch.await();
            System.out.println("\nВсе грузчики завершили работу!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    static class Loader implements Runnable {
        private final String name;
        private final int[] goods;
        private final int maxWeight;
        private final CountDownLatch latch;
        private static int currentIndex = 0;   // общий счётчик товаров

        public Loader(String name, int[] goods, int maxWeight, CountDownLatch latch) {
            this.name = name;
            this.goods = goods;
            this.maxWeight = maxWeight;
            this.latch = latch;
        }

        @Override
        public void run() {
            int loaded = 0;

            while (true) {
                int weight;

                synchronized (goods) {
                    if (currentIndex >= goods.length) break;
                    weight = goods[currentIndex];

                    if (loaded + weight > maxWeight) break;

                    loaded += weight;
                    currentIndex++;
                }

                System.out.println(name + " взял " + weight + " кг (всего: " + loaded + " кг)");
            }

            System.out.println(name + " загрузил " + loaded + " кг и отправился разгружать!");
            latch.countDown();
        }
    }
}