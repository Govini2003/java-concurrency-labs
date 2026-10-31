package Lec4;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private String accountNo;
    private BigDecimal balance;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    //creating two separate locks for read lock and write lock
    private final Lock readLock = lock.readLock();//will be used by the reader
    private final Lock writeLock = lock.writeLock(); //will be used by the writer

    public BankAccount(String accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+"Reading balance"+balance);
        try {
            Thread.sleep(100);
            return balance;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            readLock.unlock();
        }
    }
    public void deposit(BigDecimal amount) {//writer is going to deposit
        writeLock.lock();
        try{
            if(amount.doubleValue() > 0){
                this.balance = this.balance.add(amount);//updates the balance
                System.out.println(Thread.currentThread().getName()+"Deposited - "+amount+" " +"Current balance is - "+balance);
            }
            else{
                System.out.println("Invalid amount to deposit");
            }
        }finally {
            writeLock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) {
        writeLock.lock();
        try{
            if(balance.compareTo(amount) >= 0){
                this.balance = this.balance.subtract(amount);
                System.out.println(Thread.currentThread().getName()+"Withdrawal - "+amount+" Current balance is - "+balance);
            }
            else{
                System.out.println("Insufficient balance to withdraw");
            }
        }finally {
            writeLock.unlock();
        }
    }
}
