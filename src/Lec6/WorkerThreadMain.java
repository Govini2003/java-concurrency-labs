package Lec6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThreadMain {
    public static void main(String[] args) {

//        Executor executor = newFixedThreadPool(3);//there are 3 threads inside the thread pool
//        for(int i=0;i<3;i++){
//            executor.execute(new WorkerThread());
//        }


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            executorService.submit(new WorkerThread());
        }
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }
}
