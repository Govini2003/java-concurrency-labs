package Lec4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiSlotReentrant {
    private List<String>orders;
    private int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull=lock.newCondition();
    private final Condition notEmpty=lock.newCondition();

    public MultiSlotReentrant(int capacity) {
        this.capacity = capacity;
        orders=new ArrayList<>();
    }

    public void placeOrder(String order){//when creating a reentrant lock don't use the synchronized keyword
        lock.lock();//acquire the lock
        try {
            while(orders.size()==capacity){
                System.out.println(Thread.currentThread().getName()+" "+"Waiting...");
                notFull.await();//producer thread will wait until the list is not full
            }
            orders.add(order);
            System.out.println(Thread.currentThread().getName()+" "+"Placed order "+order);
            notEmpty.signal();
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();//release the lock
        }
    }

    public void takeOrder(){
        lock.lock();
        try {
            while(orders.isEmpty()){
                System.out.println(Thread.currentThread().getName()+" "+"Waiting...");
                notEmpty.await();//thread will wait until the list is not empty
            }
            String order=orders.remove(0);
            System.out.println(Thread.currentThread().getName()+" "+"Took the order "+order);
            notFull.signalAll();
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }

}
