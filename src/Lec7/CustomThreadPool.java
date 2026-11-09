package Lec7;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {
    public static void main(String[] args) {
        Order[] orders = new Order[15];

        for (int i = 0; i < 15; i++) {
            orders[i] = new Order(i, "Order " + i);
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,
                6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),new CustomThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        // abort policy - throws rejectionExectionException
        // callerRunPolicy - rejected tasks will be executed by the thread that calls the submit task
        // discard policy - Discards the rejected task. No error msg will be thrown
        // discard old policy - discards the oldest task.
        // add threadFactory to constructor only if customizing.

        for (Order order: orders) {
            threadPoolExecutor.submit(new OrderProcess(order));
        }

        threadPoolExecutor.shutdown();
    }
}