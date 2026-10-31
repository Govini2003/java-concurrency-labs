package Lec6;

import java.util.concurrent.Semaphore;

public class SharedBuffer {
    private final Semaphore itemAvailable=new Semaphore(0);//semaphore object
    private final Semaphore itemNotAvailable=new Semaphore(1);
    private String item;

    public void add(String item){
        try {
            itemNotAvailable.acquire();// available permit becomes 0
            this.item=item;
            System.out.println(Thread.currentThread().getName()+"- Added item "+item+" to buffer");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            itemAvailable.release();//available permit=1
        }
    }
    public void remove(){
        try {
            itemAvailable.acquire();//available permit becomes 0 - consumer acquires the lock when item is available
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"- Removed item "+item +" from buffer");

        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            itemNotAvailable.release();//available permit becomes 1
        }
    }
}
