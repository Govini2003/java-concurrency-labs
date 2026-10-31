package Lec6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MultiSlotSharedBuffer {
    private final Semaphore emptySlots = new Semaphore(5);
    private final Semaphore occupiedSlots = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    private List<String> items=new ArrayList<String>();

    public void add(String item){
        try {
            emptySlots.acquire();
            mutex.acquire();

            items.add(item);//producers item-adds that to the array
            System.out.println(Thread.currentThread().getName()+"- Produced "+item);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            occupiedSlots.release();
            mutex.release();
        }
    }

    public void remove(){
        try {
            occupiedSlots.acquire();
            mutex.acquire();

            String item = items.remove(0);
            System.out.println(Thread.currentThread().getName()+"- Consumed "+item);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            emptySlots.release();
            mutex.release();
        }
    }
}
