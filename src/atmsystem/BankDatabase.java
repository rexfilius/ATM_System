
package atmsystem;

public class BankDatabase {
    
    public BankDatabase() {
        accounts = new Account[3];
        accounts[0] = new Account(12345, 54321, 10000.0, 12000.0);
        accounts[1] = new Account(34567, 76543, 20000.0, 20000.0);
        accounts[2] = new Account(23456, 65432, 45000.0, 50000.0);
    }
    
    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);
        if(userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false;
    }
    
    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance();
    }
    
    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    }
    
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    }
    
    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    }
    
    private Account getAccount(int accountNumber) {
        for(Account currentAccount : accounts) {
            if(currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }
        return null;
    }
    
    private Account[] accounts;
}
