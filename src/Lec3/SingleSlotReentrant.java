package Lec3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SingleSlotReentrant {
    ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

    private boolean orderAvailable=false;
    private String order;


    public void placeOrder(String food){
        lock.lock();
        try{
        while(orderAvailable){

                condition.await(); // puts the producer thread to wait
                //defines in what condition thread should put in wait state
                //if this is multislot will use more conditions
        }

        //order is not available
        this.order=food; //placing the order
        orderAvailable=true;
        System.out.println(Thread.currentThread().getName()+" Placed order "+food);
        condition.signalAll();//notifies the order threads in waiting state

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        finally{
            lock.unlock();
        }
    }

    public void takeOrder(){
        lock.lock();//before doing anything should lock the shared resource
        try {
            while (!orderAvailable) {
                System.out.println(Thread.currentThread().getName()+" Waiting... ");
                condition.await();//puts thread to wait, same as  wait method.
                //synchronized - wait , reentrant - await
            }

            String currentOrder=order;
            orderAvailable=false;
            System.out.println(Thread.currentThread().getName()+" Took order "+currentOrder);
            condition.signalAll();//uses signalAll(); instead of notifyAll();

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        finally{ //if we put unlock method in try or catch blocks it will lock when trying to execute or else when catching the interruption
            lock.unlock();//once the thread completes the execution, we should unlock the lock
        }
    }
}
