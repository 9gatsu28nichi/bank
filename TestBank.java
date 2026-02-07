public class TestBank{
    public static void main(String[] args) {

        BankAccount a1 = new BasicAccount("001", "Alice", 1000);
        BankAccount a2 = new BasicAccount("002", "Bob", 500);

        BankService bank = new CoreBankSystem();

        bank.deposit(a1, 200);
        bank.withdraw(a2, 100);
        bank.transfer(a1, a2, 300);

        System.out.println(a1.getBalance()); // 900
        System.out.println(a2.getBalance()); // 700
    }
}
