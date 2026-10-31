package Lec1;

import java.math.BigDecimal;

public class Bank {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount=new BankAccount("123",new BigDecimal(10000));
        Thread boyThread=new Thread(new Boy(bankAccount));
        Thread girlThread=new Thread(new Girl(bankAccount));
        boyThread.start();
        girlThread.start();
    }
}
