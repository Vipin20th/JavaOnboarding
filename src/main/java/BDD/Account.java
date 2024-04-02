package BDD;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Error: Insufficient balance");
        }
    }

    public int getBalance() {
        return balance;
    }
}