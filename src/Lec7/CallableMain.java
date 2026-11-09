package Lec7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        // sum value returned by the sumCalculation will now be stored in the Future object.
        Future future = service.submit(new SumCalculation());

        // the future.get function can cause exceptions. so we use a try-catch block always.
        try {
            System.out.println("Sum = " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
    }
}
