package Lec8;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(new BookingTicket(i));
        }
        threadPoolExecutor.shutdown();
    }
}