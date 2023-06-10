import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A simple top-level main method to interface with the pet shop.
 * 
 * @author raodm
 *
 */
public class PetShopUI {
    /** 
     * A simple prompt to obtain input from the user.
     */
    private static final String INPUT_PROMPT = 
            "Welcome to the Pet Shop (%d pets & %d food things).\n"
          + "   What would you like to do [0 for menu]: ";

    /**
     * This is a named-constant for a string used to display a short
     * menu to the user.
     */
    private static final String MENU = 
              "    1. To add things from a text file\n"
            + "    2. Print summary of things.\n"
            + "    3. Print all things\n"
            + "    4. Print food status\n"
            + "    0. Show this menu\n"
            + "   -1. Quit\n";
    
    /**
     * Helper method enable loading things from a given text file. This method
     * is called from the main.
     * 
     * @param sc The scanner to be used to obtain path to text file.
     * @param ps The pet shop to which items are to be added.
     */
    private static void addItems(Scanner sc, PetShop ps) {
        System.out.print("Enter file name to add inventory: ");
        final String fileName = sc.next();
        try {
            ps.addItemsFromFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * The main method that displays a menu and calls appropriate methods
     * in pet shop to perform various operations.
     * 
     * @param args The command-line arguments are not used.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PetShop ps = new PetShop();
            do {
                System.out.printf(INPUT_PROMPT, ps.getPetCount(), 
                        ps.getFoodCount());
                final int choice = sc.nextInt();
                switch (choice) {
                case 0: System.out.println(MENU); 
                break;
                case 1: addItems(sc, ps);
                break;
                case 2: ps.printSummary();
                break;
                case 3: ps.printAllThings();
                break;
                case 4: ps.reportFoodStatus();
                break;
                case -1: return;
                default: System.out.println("Invalid option.");
                }
            } while (true);
        }
    }
}
