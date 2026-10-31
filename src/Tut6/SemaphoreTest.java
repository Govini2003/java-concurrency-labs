package Tut6;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        System.out.println(semaphore.availablePermits());

        try {
            semaphore.acquire();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(semaphore.availablePermits());//now there are only 3 permits available
        semaphore.release();

        System.out.println(semaphore.availablePermits());//now again there 4 permits available
    }
}
