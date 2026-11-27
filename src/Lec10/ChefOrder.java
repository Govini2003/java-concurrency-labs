package Lec10;

import java.util.concurrent.Phaser;

public class ChefOrder {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        for(int i=0;i<3;i++){
            int chefId=i;

            Thread chef=new Thread(()->{
                try{
                    //phase 0 preparing ingredients
                System.out.println(Thread.currentThread().getName() + "- Preparing ingredients");

                    Thread.sleep(500);

                System.out.println(Thread.currentThread().getName() + "- Finished preparing ingredients");

                phaser.arriveAndAwaitAdvance();

                    //phase 1 cooking

//                    if(chefId==1){
//                        phaser.register();//registering new party
//                        new Thread(()->{
//                            System.out.println(Thread.currentThread().getName() + "- Joined for cooking");
//                            try{
//                                Thread.sleep(100);
//                            }catch(InterruptedException e){
//                                throw new RuntimeException(e);
//                            }
//                            System.out.println(Thread.currentThread().getName() + "- Completed cooking");
//                            phaser.arriveAndDeregister();
//
//                        },"Chef 4").start();
//                    }

                    if(chefId==1){
                       phaser.bulkRegister(2); //to register more than 1 party
                       for(int j=4;j<6;j++){
                           int newChefId=j;
                           new Thread(()->{
                               System.out.println(Thread.currentThread().getName() + "- Joined phase 1 for cooking");
                               try{
                                Thread.sleep(500);
                            }catch(InterruptedException e){
                                throw new RuntimeException(e);
                            }
                               System.out.println(Thread.currentThread().getName() + "- Completed cooking");
                               phaser.arriveAndDeregister();

                           },"Chef "+newChefId).start();
                       }
                    }

                    System.out.println(Thread.currentThread().getName() + "- Started cooking... ");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "- Finished cooking... ");

                    phaser.arriveAndDeregister();
                }
                catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            },"Chef "+chefId);
            chef.start();
        }

    }
}
