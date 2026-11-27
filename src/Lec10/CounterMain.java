package Lec10;

public class CounterMain {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1=new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        },"Thread 1");
        t1.start();

        Thread t2=new Thread(()->{
            for(int i=0;i<10;i++) {
                counter.increment();
            }
        },"Thread 2");
        t2.start();

        try{
            t1.join();
            t2.join();

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Final count"+counter.getCount());
    }
}
