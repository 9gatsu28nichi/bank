import java.util.UUID;

public class CoreBankSystem implements BankService {

    @Override
    public boolean deposit(BankAccount account, double amount) {
        if (amount <= 0) {
            createTransaction("DEPOSIT", amount, "FAILED");
            return false;
        }

        account.updateBalance(amount);
        createTransaction("DEPOSIT", amount, "SUCCESS");
        return true;
    }

    @Override
    public boolean withdraw(BankAccount account, double amount) {
        if (amount <= 0 || account.getBalance() < amount) {
            createTransaction("WITHDRAW", amount, "FAILED");
            return false;
        }

        account.updateBalance(-amount);
        createTransaction("WITHDRAW", amount, "SUCCESS");
        return true;
    }

    @Override
    public boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (amount <= 0 || from.getBalance() < amount) {
            createTransaction("TRANSFER", amount, "FAILED");
            return false;
        }

        from.updateBalance(-amount);
        to.updateBalance(amount);
        createTransaction("TRANSFER", amount, "SUCCESS");
        return true;
    }

    private void createTransaction(String type, double amount, String status) {
        new Transaction(
                UUID.randomUUID().toString(),
                type,
                amount,
                status
        );
    }
}
