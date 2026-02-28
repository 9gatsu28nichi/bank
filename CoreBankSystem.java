import java.util.UUID;

public class CoreBankSystem implements BankService {

    @Override
    public boolean deposit(BankAccount account, double amount) {
        // synchronized prevents race condition when multiple threads update balance
        synchronized (account) {
            if (amount <= 0) {
                createTransaction("DEPOSIT", amount, "FAILED");
                return false;
            }

            account.updateBalance(amount);
            createTransaction("DEPOSIT", amount, "SUCCESS");

            System.out.println(
            Thread.currentThread().getName() +
            " running at " +
            System.currentTimeMillis()
        );
            return true;
        }
    }

    @Override
    public boolean withdraw(BankAccount account, double amount) {
        synchronized (account) {
            if (amount <= 0 || account.getBalance() < amount) {
                createTransaction("WITHDRAW", amount, "FAILED");
                return false;
            }

            account.updateBalance(-amount);
            createTransaction("WITHDRAW", amount, "SUCCESS");

            System.out.println(
            Thread.currentThread().getName() +
            " running at " +
            System.currentTimeMillis()
            );
            return true;
        }
    }

    @Override
    public boolean transfer(BankAccount from, BankAccount to, double amount) {
    //prevent deadlock by always locking accounts in the same order based on their IDs
    BankAccount first = from.id.compareTo(to.id) < 0 ? from : to;
    BankAccount second = from.id.compareTo(to.id) < 0 ? to : from;
        synchronized (first) {
            synchronized (second) {
                if (amount <= 0 || from.getBalance() < amount) {
                    createTransaction("TRANSFER", amount, "FAILED");
                    return false;
                }

                from.updateBalance(-amount);
                to.updateBalance(amount);
                createTransaction("TRANSFER", amount, "SUCCESS");

                System.out.println(
                Thread.currentThread().getName() +
                " running at " +
                System.currentTimeMillis()
                );
                return true;
            }
        }
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
