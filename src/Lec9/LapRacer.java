package Lec9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LapRacer {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            int racerId = i;
            Thread racer = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " getting ready");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " ready to start");
                    barrier.await(); // wait for all racers before the race begins
                    System.out.println(Thread.currentThread().getName() + " started race");

                    for (int lap = 1; lap <= 3; lap++) {
                        System.out.println(Thread.currentThread().getName() + " started lap " + lap);
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " completed lap " + lap);
                        barrier.await(); // wait for everyone to finish this lap
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, "Racer " + racerId);
            racer.start();
        }
    }
}