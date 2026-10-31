package Lec5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MultiSlotOrder {
    private List<String> orders=new ArrayList<>();//used to store what orders are placed
    private final Semaphore emptySlot = new Semaphore(5);//initially no order placed
    private final Semaphore occupiedSlot = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);//mutex semaphore for mutual exclusion

    public void placeOrder(String food){
        try{
            emptySlot.acquire();//only if there is empty slots producer can produce
            mutex.acquire(); //ensures only one thread access the shared resource at a time
            orders.add(food);
            System.out.println(Thread.currentThread().getName() + "Placed order" +" "+ food);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }finally {
            mutex.release();
            occupiedSlot.release();
        }
    }

    public void takeOrder(){
        try{
            occupiedSlot.acquire();
            mutex.acquire();
            String food=orders.remove(0);
            System.out.println(Thread.currentThread().getName() + "Taked order" +" "+ food);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            mutex.release();
            emptySlot.release();
            }
    }
}
