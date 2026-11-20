package Lec9;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);

        for(int i=0;i<3;i++){
            int employeeId=i;

            int finalI=i;
            Thread employee=new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Starting executing the task");
                try{
                    Thread.sleep(finalI*500);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"has completed the task");
                latch.countDown();
            },"Employee "+employeeId);
            employee.start();
        }

        Thread manager=new Thread(()->{
            try {
                latch.await(); //put manager thread to wait until count becomes 0
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Manager approved the project");
        },"Manager");
        manager.start();
    }
}
