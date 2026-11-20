package Lec9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRacing {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        for(int i=0;i<3;i++){
            int racerId=i;
            Thread racer= new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Getting ready for race");

                try{
                    Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" is ready to start");

                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+" started the race");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

            },"Racer"+racerId);
            racer.start();
        }
    }
}
