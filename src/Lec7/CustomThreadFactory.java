package Lec7;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        // customize the thread properties that will be created in thread pool
        Thread thread = new Thread(r, "Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }
}