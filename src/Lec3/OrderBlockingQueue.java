package Lec3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class OrderBlockingQueue {
    private BlockingQueue<String> order=new ArrayBlockingQueue<>(1);

    public void placeOrder(String food){
        try{
            System.out.println(Thread.currentThread().getName()+"Placed order"+food);
            order.put(food);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public void takeOrder(){
        try{
            String food=order.take();
            System.out.println(Thread.currentThread().getName()+"Took the order");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
