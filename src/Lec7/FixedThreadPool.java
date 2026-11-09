package Lec7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        Order[] orders = new Order[15];
        for (int i = 0; i < orders.length; i++) {
            orders[i] = new Order(i, "order-" + i);
        }

        // create thead pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int j = 0; j < orders.length; j++) {
            executor.submit(new OrderProcess(orders[j]));
        }

        executor.shutdown();
    }
}