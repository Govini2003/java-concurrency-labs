package Lec8.VirtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {


        //Method 1 :  Creating virtual Thread using ofVirtual method
        Thread t1 = Thread.ofVirtual().name("Thread 1").unstarted(()->{
            //Task executed by Thread
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        });
        t1.start();


        //Method 2 : Creating virtual Thread Using Executors
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        service.submit(()->{
            for(int i=1;i<10;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);  //can give name using custom ThreadFactory
            }
        });



//Method3 -  Creating virtual Thread Using Thread Builder
        Thread.Builder builder = Thread.ofVirtual().name("Builder Thread");
        builder.start(()->{
            for(int i=1;i<5;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        });



        try{
            t1.join(); //Main thread will wait until t1 completes execution
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

//initially didn't get output cuz virtual thread by default is demon thread , therefore we need join() method to get output
//implement TicketBooking using all 3 methods and compare - HW