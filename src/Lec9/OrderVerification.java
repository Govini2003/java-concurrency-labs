package Lec9;

import java.util.concurrent.CountDownLatch;

public class OrderVerification {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"- Checks for product availability");
            try{
                Thread.sleep(500);

            }catch(InterruptedException e){
                throw new RuntimeException(e);

            }
            System.out.println(Thread.currentThread().getName()+"- Product is available");
            latch.countDown();
        },"Thread 1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"-verifying payment....");
            try{
                Thread.sleep(200);

            }catch(InterruptedException e){
                throw new RuntimeException(e);

            }
            System.out.println(Thread.currentThread().getName()+"-verified payment");
            latch.countDown();
        },"Thread 2");
        thread2.start();


    }
}
