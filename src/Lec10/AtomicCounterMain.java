package Lec10;

public class AtomicCounterMain {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        Thread t1 =new Thread(()->{
            for(int i=0;i<5;i++){
                counter.increment();
            }
        },"Thread 1 :");

        Thread t2 =new Thread(()->{
            for(int i=0;i<5;i++){
                counter.increment();
            }
        },"Thread 2 :");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }


    }
}
