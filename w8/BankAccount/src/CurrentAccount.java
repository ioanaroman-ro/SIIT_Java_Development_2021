import java.util.Arrays;
import java.util.List;

public class CurrentAccount extends Account{
    public Boolean overdraft;

    public CurrentAccount(String description, String IBAN, double balance) {
        super(description, IBAN, balance);
    }

    public CurrentAccount(String description, String IBAN, double balance, Boolean overdraft) {
        super(description, IBAN, balance);
        this.overdraft = overdraft;
    }

    public CurrentAccount() {
        super();
    }


    public Boolean getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Boolean overdraft) {
        this.overdraft = overdraft;
    }

    public static void loadCurrentAccounts() {
        CurrentAccount currentAccount1 = new CurrentAccount("Current account 1", "RO25RON12345678901234561", 10000, true);
        CurrentAccount currentAccount2 = new CurrentAccount("Current account 2", "RO25RON12345678901234562", 2500, false);
        List<Account> accounts = Arrays.asList(currentAccount1, currentAccount2);
        accounts.addAll(accounts);
        System.out.println(accounts);
    }

    @Override
    public void print() {
        System.out.println(
                description +
                ", IBAN= " + IBAN +
                ", balance= " + balance +
                ", overdraft= " + overdraft);
    }

    @Override
    public String toString() {
        return "\n" + "CurrentAccount{" +
                "description='" + description + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", overdraft=" + overdraft +
                '}';
    }

    @Override
    public void print(double balance) {

    }
}