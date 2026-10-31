package Lec1;

import java.math.BigDecimal;

public class Boy implements Runnable {

    private BankAccount bankAccount;
    public Boy(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bankAccount.withdraw(new BigDecimal(6000));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
