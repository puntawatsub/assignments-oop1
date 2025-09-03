package assignment3_3.one;

public class BankAccount {
    // Your variable declarations and code here
    private static int totalAccounts = 0;

    private double balance;
    private final int accountNumber;

    public BankAccount(double money) {
        totalAccounts++;
        this.balance = money;
        this.accountNumber = totalAccounts;
    }

    public BankAccount() {
        totalAccounts++;
        this.balance = 0;
        this.accountNumber = totalAccounts;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}