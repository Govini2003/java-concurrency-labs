package Lec5;

import java.util.concurrent.Semaphore;

public class Order {
    private final Semaphore orderAvailable = new Semaphore(0); // binary semaphore ,cause 1 one order takes-single slot
    private final Semaphore orderNotAvailable= new Semaphore(1);//1- order available, 0-order not available
    private String food;

    public void placeOrder(String food) {
        try {
            orderNotAvailable.acquire(); //acquires the permit when order is not available
            System.out.println(Thread.currentThread().getName() + "Placed order" +" "+ food);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            orderNotAvailable.release();//releases the permit - something like unlock
        }
    }

        public void takeOrder(){
            try{
                orderAvailable.acquire();//after consumer acquires the lock permit becomes 1-1=0
                System.out.println(Thread.currentThread().getName() + "- Preparing");
                Thread.sleep(2000);//preparation time
                System.out.println(Thread.currentThread().getName() + " Prepared the order"+ food);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            } finally {
                orderAvailable.release();//after releasing permit becomes 1 again
            }
        }


}
