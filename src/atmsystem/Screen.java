
package atmsystem;

public class Screen {
    
    public void displayMessage(String message) {
        System.out.print(message);
    }
    
    public void displayMessageLine(String message) {
        System.out.println(message);
    }
    
    public void displayNairaAmount(double amount) {
        System.out.printf("NGN%,.2f", amount);
    }
}
