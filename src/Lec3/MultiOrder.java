package Lec3;

import java.util.ArrayList;
import java.util.List;

public class MultiOrder {
    private List <String> orders;
    private int capacity;
    public MultiOrder(int capacity, String order) {
        this.capacity = capacity;
    }

    public MultiOrder(int capacity) {
        this.capacity = capacity;
        orders = new ArrayList<>(capacity);
    }

        public synchronized void placeOrder(String food){
            while(orders.size() == capacity) {
                try {
                    System.out.println(Thread.currentThread().getName()+"Waiting...");
                    wait();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //there is space to place order
            orders.add(food);
            System.out.println(Thread.currentThread().getName()+"Placing order "+food);
        }
        public synchronized void takeOrder(){
            while(orders.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName()+"Waiting...");
                    wait();
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //order is available to take
        String order = orders.remove(0);
        System.out.println(Thread.currentThread().getName()+"Took the order "+order);
        notifyAll();
        }
    }

