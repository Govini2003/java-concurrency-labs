package Lec10;

import java.util.concurrent.Exchanger;

public class PackageDelivery {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();

        Thread worker1=new Thread(()->{
            String package1 ="Package B";
            System.out.println("Worker 1 has "+package1);
            try {
                String received = exchanger.exchange(package1);
                System.out.println("Worker received the "+received);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        },"Worker 1");

        Thread worker2=new Thread(()->{
            String package2 ="Package A";
            System.out.println("Worker 2 has "+package2);
            try {
                String received = exchanger.exchange(package2);
                System.out.println("Worker received the "+received);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        },"Worker 2");
        worker1.start();
        worker2.start();
    }
}
