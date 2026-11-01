package Tut6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends Thread {
    private final Semaphore counters;        // shared semaphore (3 permits)
    private final AtomicInteger inService;   // only used to show how many are being served

    public Customer(int id, Semaphore counters, AtomicInteger inService) {
        super("Customer-" + id);
        this.counters = counters;
        this.inService = inService;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " arrived at the bank");

            counters.acquire();              // wait here if all 3 counters are busy
            try {
                int now = inService.incrementAndGet();
                System.out.println(getName() + " is being served|customers at counters = " + now);

                Thread.sleep(2000);          // simulate the transaction

                System.out.println(getName() + " finished");
            } finally {
                inService.decrementAndGet();
                counters.release();          // free the counter for the next customer
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
