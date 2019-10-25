
package atmsystem;

public class CashDispenser {
    
    public CashDispenser() {
        count = INITIAL_COUNT;
    }
    
    public void dispenseCash(int amount) {
        int billsRequired = amount / 500;
        count -= billsRequired;
    }
    
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 500;
        if(count >= billsRequired)
            return true;
        else
            return false;
    }
    
    private final static int INITIAL_COUNT = 2000;   //number of bills in dispenser when the ATM starts
    private int count;                              //number of 500 Naira bills remaining
}
