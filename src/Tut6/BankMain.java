package Tut6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        Semaphore counters = new Semaphore(3);        // 3 service counters
        AtomicInteger inService = new AtomicInteger(0);

        Customer[] customers = new Customer[7];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(i + 1, counters, inService);
        }

        for (Customer c : customers) {
            c.start();                                // all 7 arrive together
        }
        for (Customer c : customers) {
            c.join();
        }

        System.out.println("All customers have been served.");
    }
}