package Lec1;

import java.math.BigDecimal;

public class BankAccount {
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public synchronized BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void withdraw(BigDecimal amount) {
        System.out.println(Thread.currentThread().getName() + " Trying to withdraw " + amount);

        if (amount.compareTo(balance) <= 0) {
            this.balance = balance.subtract(amount);
            System.out.println(Thread.currentThread().getName() + " After withdrawing balance is " + balance);
        }else
            System.out.println(Thread.currentThread().getName() + " Insufficient account balance" );
    }

}