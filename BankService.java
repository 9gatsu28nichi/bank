public interface BankService {

    boolean deposit(BankAccount account, double amount);
    boolean withdraw(BankAccount account, double amount);
    boolean transfer(BankAccount from, BankAccount to, double amount);
}
