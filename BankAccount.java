public abstract class BankAccount {

    protected String id;
    protected String name;
    protected double balance;

    public BankAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    protected void updateBalance(double amount) {
        this.balance += amount;
    }
}

