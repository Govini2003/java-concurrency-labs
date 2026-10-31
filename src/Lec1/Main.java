package Lec1;

public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        //create a thread object
        Thread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new MyThread();
        thread2.start();

        //Thread creating using runnable interface
        Thread thread3 = new MyThread(new MyRunnable());
        thread3.start();


        Thread thread4 = new MyThread(new MyRunnable(), "My Runnable");
        thread4.start();

        //Lambda thread
        Thread lambdaThread1 = new MyThread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "Lambda Thread");
        lambdaThread1.start();

        //Anonymous thread
        Thread anonymousThread1 = new Thread("Anonymous thread") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        };
        anonymousThread1.start();

        Thread anonymousRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"Anonymous Thread using runnable interface");
        anonymousRunnable.start();
    }
}

