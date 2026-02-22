public class BasicAccount extends BankAccount {
    private final double interestRate = 0.01;
    public BasicAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public synchronized void calculateInterest(){
        double interest = this.balance * interestRate;
        this.balance += interest;
    }
}
