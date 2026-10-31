//package Lec6;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class ScheduledExecutorService {
//    public static void main(String[] args) {
//        ExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        for(int i=0;i<3;i++){
//            service.schedule(new WorkerThread(),5, TimeUnit.SECONDS);
//
//        }
//
//    }
//}
//