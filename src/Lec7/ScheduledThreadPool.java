package Lec7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        Order[] orders = new Order[15];

        for (int i = 0; i < orders.length; i++) {
            orders[i] = new Order(i, "Order"  + i);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < orders.length; i++) {
//            executorService.schedule(new OrderProcess(orders[i]), 5, TimeUnit.SECONDS);
            // executes the task after 5 seconds after running

            // it will wait for the remaining time before repeating. execute=3s; delay=8s; wait=8-3=5s; execute + wait -> re-execute.
//            executorService.scheduleAtFixedRate(new OrderProcess(orders[i]), 2, 8, TimeUnit.SECONDS);

            // it will wait 8 seconds after the first execution to execute again. execute -> wait -> re-execute
            executorService.scheduleWithFixedDelay(new OrderProcess(orders[i]), 2, 8, TimeUnit.SECONDS);
        }

        executorService.shutdown();
    }
}