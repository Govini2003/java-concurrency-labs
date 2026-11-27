package Lec10;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    AtomicInteger counter = new AtomicInteger();//initial count=0

    public void increment() {
        //increment count by 1
        counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+counter.get());
    }
    public int getCount(){
        return counter.get();//return the current value
    }
}
