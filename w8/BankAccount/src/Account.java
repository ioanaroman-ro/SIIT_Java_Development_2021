public abstract class Account implements Printable, DepositFunds{
    public String description;
    public String IBAN;
    public double balance;

    public Account(String description, String IBAN, double balance) {
        this.description = description;
        this.IBAN = IBAN;
        this.balance = balance;
    }
    public Account(){
    }

    public void deposit(double amount){};

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void print() {
        System.out.println("\n" + description + " " + IBAN + " " + balance);
    }

    @Override
    public String toString() {
        return "\n" + "Account{" +
                "description='" + description + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                '}';
    }


    public abstract void print(double balance);
}