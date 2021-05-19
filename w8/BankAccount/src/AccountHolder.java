import java.util.ArrayList;
import java.util.List;

public class AccountHolder {
    public String name;
    public List<Account> accounts = new ArrayList<>();

    public AccountHolder(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public AccountHolder() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    };

    public void print() {
        System.out.println( name +
                ", accounts" + accounts +
                '}');
    }
    public void print(AccountHolder ah) {
        System.out.println( ah.name + " :");
        for (Account account : accounts){
            if (account instanceof SavingsAccount){
                account.print(account.getBalance());
            }
        }
    }

    public void deposit(double amount) {
            for (Account account : accounts){
                if (account instanceof SavingsAccount){
                    account.deposit(amount);
                }
            }
    }
}