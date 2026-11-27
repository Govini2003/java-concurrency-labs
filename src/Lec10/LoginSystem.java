package Lec10;

import java.util.concurrent.atomic.AtomicBoolean;

public class LoginSystem {
    public static void main(String[] args) {
         AtomicBoolean loginStatus =new AtomicBoolean();//by default initial value becomes false

         Thread t1= new Thread(()->{
             System.out.println(Thread.currentThread().getName()+"Started login");
             loginStatus.compareAndSet(false,true);
             try {
                 Thread.sleep(2000);
             }
             catch(InterruptedException e){
                 throw new RuntimeException(e);
             }
             System.out.println(Thread.currentThread().getName()+"finished login");
             loginStatus.set(false);
         },"User 1 ");

        Thread t2= new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"Started login");
            loginStatus.compareAndSet(false,true);
            try {
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"finished login");
            loginStatus.set(false);
        },"User 2 ");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();

        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Final login status : "+loginStatus.get());

    }
}
