
package atmsystem;

public abstract class Transaction {
    
    public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        accountNumber = userAccountNumber;
        screen = atmScreen;
        bankDatabase = atmBankDatabase;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public Screen getScreen() {
        return screen;
    }
    
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }
    
    public abstract void execute();
    
    private int accountNumber;
    private Screen screen;
    private BankDatabase bankDatabase;
}
