package Lec10;

import java.util.concurrent.atomic.AtomicReference;

public class SharedUserApplication {
    public static void main(String[] args) {
        AtomicReference<String> applicationStatus = new AtomicReference<String>("OFFLINE");

        Thread thread1 = new Thread(() -> {
            applicationStatus.compareAndSet("OFFLINE","ONLINE");
            System.out.println(Thread.currentThread().getName()+"CHanged the status to online");

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        },"User 1 ");

        Thread thread2 = new Thread(() -> {
            applicationStatus.compareAndSet("ONLINE","BUSY");
            System.out.println(Thread.currentThread().getName()+"Application is busy");

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        },"User 2 ");

        Thread thread3 = new Thread(() -> {
            applicationStatus.compareAndSet("BUSY","OFFLINE");
            System.out.println(Thread.currentThread().getName()+"Application is offline");

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        },"User 3 ");

        thread1.start();
        thread2.start();
        thread3.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("Final status :"+applicationStatus.get());
    }
}
