package Lec9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class StudentsProject {
    public static void main(String[] args) {
        CyclicBarrier project = new CyclicBarrier(3);
         for(int i=0;i<3;i++){
             int studentId=i;
         }

         Thread student1= new Thread(()->{
             System.out.println(Thread.currentThread().getName()+" started collecting information");
             try{
                 Thread.sleep(1500);
                 System.out.println(Thread.currentThread().getName()+" finished collecting information");
                 project.await();
             }catch(InterruptedException |BrokenBarrierException e){
                 throw new RuntimeException(e);
             }
         },"Student 1");
         student1.start();

        Thread student2= new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" started preparing the slides");
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" finished preparing the slides");
                project.await();
            }catch(InterruptedException |BrokenBarrierException e){
                throw new RuntimeException(e);
            }
        },"Student 2");
        student2.start();

        Thread student3= new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" started refining the content");
            try{
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" finished refining the content");
                project.await();
            }catch(InterruptedException | BrokenBarrierException e){
                throw new RuntimeException(e);
            }
        },"Student 3");
        student3.start();

    }
}
