
package Lec4;

import java.math.BigDecimal;

public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount bankAccount =
                new BankAccount("2111", new BigDecimal("10000"));

        Thread[] readers = new Thread[5];

        try {
            // Reader threads
            for (int i = 0; i < readers.length; i++) {
                readers[i] = new Thread(() -> {
                    System.out.println(
                            Thread.currentThread().getName()
                    );

                    // Call your BankAccount read method here
                }, "Reader " + i);

                readers[i].start();
            }

            // Writer 1: Deposit money
            Thread writer1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    bankAccount.deposit(new BigDecimal("2000"));
                }
            }, "Writer 1");

            // Writer 2: Withdraw money
            Thread writer2 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    bankAccount.withdraw(new BigDecimal("1000"));
                }
            }, "Writer 2");

            // Writer 3: Withdraw money
            Thread writer3 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    bankAccount.withdraw(new BigDecimal("500"));
                }
            }, "Writer 3");

            writer1.start();
            writer2.start();
            writer3.start();

            // Wait for all writer threads
            writer1.join();
            writer2.join();
            writer3.join();

            // Wait for all reader threads
            for (Thread reader : readers) {
                reader.join();
            }

            System.out.println("All threads have finished.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
