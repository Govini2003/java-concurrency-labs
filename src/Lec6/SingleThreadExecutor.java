package Lec6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//thread pool will have only one thread, and there is an order always
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Task " + taskId + " running on "
                            + Thread.currentThread().getName());
                }
            });
        }

        executorService.shutdown();
    }
}
