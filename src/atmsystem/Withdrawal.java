
package atmsystem;

public class Withdrawal extends Transaction {
    
    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase,
                        Keypad atmKeypad, CashDispenser atmCashDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
        cashDispenser = atmCashDispenser;
    }
    
    @Override
    public void execute() {
        boolean cashDispensed = false;
        double availableBalance;
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        do {
          amount = displayMenuOfAmounts();
          if(amount != CANCELLED) {
              availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
              if(amount <= availableBalance) {
                  if(cashDispenser.isSufficientCashAvailable(amount)) {
                      bankDatabase.debit(getAccountNumber(), amount);
                      cashDispenser.dispenseCash(amount);
                      cashDispensed = true;
                      screen.displayMessageLine(("Your cash has been dispensed" + 
                                "\nPlease take your cash now."));
                    } else {
                      screen.displayMessageLine("\nInsufficient cash available in the ATM." + 
                              "\n\nPlease choose a smaller amount.");
                    }
                } else {
                  screen.displayMessageLine("\nInsufficient funds in your account." + 
                                "\n\nPlease choose a smaller amount.");  
                }    
            } else {
              screen.displayMessageLine("\nCancelling transaction...");
              return;
            }
        } while(!cashDispensed);
    }
    
    private int displayMenuOfAmounts() {
        int userChoice = 0;
        Screen screen = getScreen();
        int[] amounts = {0, 500, 1000, 2000, 5000, 10000};
        
        while(userChoice == 0) {
            screen.displayMessageLine("\nWithdrawal Menu: ");
            screen.displayMessageLine("1 - NGN500");
            screen.displayMessageLine("2 - NGN1000");
            screen.displayMessageLine("3 - NGN2000");
            screen.displayMessageLine("4 - NGN5000");
            screen.displayMessageLine("5 - NGN10000");
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessage("\nChoose a withdrawal amount: ");
            int input = keypad.getInput();
            switch(input) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    userChoice = amounts[input];
                    break;
                case CANCELLED:
                    userChoice = CANCELLED;
                    break;
                default:
                    screen.displayMessageLine("\nInvalid selection. Try again.");
            }
        }
        return userChoice;
    }
    
    private int amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    
    // Constant corresponding to menu option to cancel
    private static final int CANCELLED = 6;
}
