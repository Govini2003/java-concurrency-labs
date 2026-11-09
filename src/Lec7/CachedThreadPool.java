package Lec7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        Order[] orders = new Order[15];

        for (int i = 0; i < orders.length; i++) {
            orders[i] = new Order(i, "Order"  + i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < orders.length; i++) {
            executorService.submit(new OrderProcess(orders[i]));
        }

        executorService.shutdown();
    }
}

