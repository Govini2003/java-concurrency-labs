package Lec3;

public class ThreadLifeCycle {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());

            synchronized (lock) {
                System.out.println("T1 waiting for 2 seconds");
                try {
                    Thread.sleep(2000);

                    System.out.println("T1 is waiting for notification...");
                    lock.wait(); // releases the lock
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("T1 is finished");
        }, "T1");

        Thread t2 = new Thread(() -> {
            System.out.println("T2 is trying to acquire the lock");
            synchronized (lock) {
                lock.notifyAll();
                System.out.println("T2 sent notification");
            }
            System.out.println("T2 is finished");
        }, "T2");


        // NEW
        System.out.println("T1 state : " + t1.getState());

        t1.start();

        // this is to see that t1 is going to sleep. here we put the main thread to sleep.
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("T1 state : " + t1.getState());

        t2.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("T2 state : " + t2.getState());


    }
}