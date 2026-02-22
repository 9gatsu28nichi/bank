public class TestBank {
    public static void main(String[] args) {
        BankAccount a1 = new BasicAccount("001", "Alice", 1000);
        BankAccount a2 = new BasicAccount("002", "Bob", 500);

        BankService bank = new CoreBankSystem();

        Thread t1 = new Thread(() -> bank.deposit(a1, 200));
        Thread t2 = new Thread(() -> bank.withdraw(a2, 50));
        Thread t3 = new Thread(() -> bank.transfer(a1, a2, 100));
        Thread t4 = new Thread(() -> a1.calculateInterest());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance of Alice: " + a1.getBalance());
        System.out.println("Final balance of Bob: " + a2.getBalance());
    }
}
