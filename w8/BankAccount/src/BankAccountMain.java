public class BankAccountMain {

    public static void main(String[] args) {
        AccountHolder ah1 = new AccountHolder();
        AccountHolder ah2 = new AccountHolder();
        ah1.setName("John Doe");
        ah2.setName("Jane Doe");
        CurrentAccount currentAccount1 = new CurrentAccount("Current account 1", "RO25RON12345678901234561", 10000, true);
        CurrentAccount currentAccount2 = new CurrentAccount("Current account 2", "RO25RON12345678901234562", 2500, false);
        SavingsAccount savingsAccount1 = new SavingsAccount("Savings account 1", "RO25RON12345678901234563", 100000, 5.25);
        SavingsAccount savingsAccount2 = new SavingsAccount("Savings account 2", "RO25RON12345678901234564", 100, 5.25);

        ah1.addAccount(currentAccount1);
        ah2.addAccount(currentAccount2);
        ah1.addAccount(savingsAccount1);
        ah2.addAccount(savingsAccount1);
        ah2.addAccount(savingsAccount2);

        ah1.print();
        ah2.print();

        //for 3 months
        for (int i = 0; i < 3; i++) {
            ah1.deposit(100);
            ah2.deposit(200);
            System.out.println("Month " + (i + 1));
            ah1.print(ah1);
            ah2.print(ah2);
            System.out.println("____________________");
        }

    }
}
