
package atmsystem;
import java.util.Scanner;

public class Keypad {
    
    public Keypad() {
        input = new Scanner(System.in);
    }
    
    public int getInput() {
        return input.nextInt();
    }
    
    private Scanner input;
}
