public abstract class BankAccount {

    protected String id;
    protected String name;
    protected double balance;

    public BankAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    protected synchronized void updateBalance(double amount) {
        this.balance += amount;
    }
}

