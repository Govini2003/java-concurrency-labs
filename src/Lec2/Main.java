package Lec2;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        },  "Thread 1");
        Thread thread2 = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        },  "Thread 2");

        Thread thread3 = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+"-"+i);
            }
        },  "Thread 3");

        System.out.println("Thread 1 priority - "+thread1.getPriority());
        System.out.println("Thread 2 priority - "+thread2.getPriority());
        System.out.println("Thread 3 priority - "+thread3.getPriority());
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        //even if gave the high priority thread 3 won't execute first. This also decides by thread scheduler
        thread1.start();
        thread2.start();
        thread3.start();
}
}
