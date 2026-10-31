package Lec3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultiOrderBlockingQueue {
    private BlockingQueue<String> orders;

    private int capacity;
    public MultiOrderBlockingQueue(int capacity){
        this.capacity=capacity;
        orders=new ArrayBlockingQueue<>(capacity);
    }
    public void placeOrder(String food) {
        try {
            System.out.println(Thread.currentThread().getName() + "Placed" + food);
            orders.put(food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeOrder(){
        try{
            String food=orders.take();
            System.out.println(Thread.currentThread().getName()+"Taking"+food);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
