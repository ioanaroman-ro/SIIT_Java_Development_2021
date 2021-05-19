import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class SavingsAccount extends Account{
    public double interestRate;

    public SavingsAccount(String description, String IBAN, double balance, double interestRate) {
        super(description, IBAN, balance);
        this.interestRate = interestRate;
    }

    public SavingsAccount() {

    }

    public static void loadSavingsAccounts() {
        SavingsAccount savingsAccount1 = new SavingsAccount("Savings account 1", "RO25RON12345678901234563", 100000, 5.25);
        SavingsAccount savingsAccount2 = new SavingsAccount("Savings account 2", "RO25RON12345678901234564", 200000, 3.25);
        List<Account> accounts = Arrays.asList(savingsAccount1, savingsAccount2);
        System.out.println(accounts);
        accounts.addAll(accounts);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public void deposit(double amount){
        double newBalance = this.getBalance() + amount;
        double monthlyInterestRate =  ((this.interestRate / 100) / 12);
        this.setBalance(((newBalance * monthlyInterestRate) * 3) + newBalance);
    }

    @Override
    public void print() {
        System.out.println(description +
                ", IBAN= " + IBAN +
                ", balance= " + balance +
                ", interestRate=" + interestRate +
                "%");
    }

    @Override
    public String toString() {
        return "\n" + "SavingsAccount{" +
                "description='" + description + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                "%" + '}';
    }
    public void print(double balance){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        System.out.println("Current balance for " + description + " is " + df.format(this.getBalance()));
    };
}