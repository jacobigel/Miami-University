import java.util.Scanner;

/**
 * The driver to test the operation of the CookBook class.
 * 
 * @note DO NOT MODIFY THIS CLASS
 * 
 * @author raodm
 *
 */
public class CookBookMenu {
    /**
     * Internal helper method to handle checking if a recipie exists.
     * 
     * @param cb       The cook book object to be used.
     * @param keyboard The scanner object to be used.
     */
    private static void checkRecipeExists(CookBook cb, Scanner keyboard) {
        System.out.print("Enter recipe text file to search: ");
        try {
            Recipe r = Recipe.createRecipe(keyboard.next());
            System.out.println("Searching for recipe " + r.getName());
            if (cb.hasRecipe(r)) {
                System.out.println("Recipe was found in cook book");
            } else {
                System.out.println("Recipe not found.");
            }
        } catch (Exception e) {
            System.out.println("Unable to load recipe because:\n"
                    + e.getMessage());
        }
    }

    /**
     * The main method displays a simple menu to the user for testing the
     * operations of the cook book class.
     * 
     * @param args The command-line arguments are not used.
     */
    public static void main(String[] args) {
        CookBook cb = new CookBook();
        Scanner keyboard = new Scanner(System.in);
        String cmd;
        do {
            System.out
                    .print("Enter command (add,search,check,load,save,quit): ");
            cmd = keyboard.next().toLowerCase();
            if ("add".equals(cmd)) {
                System.out.print("Enter recipe text file name: ");
                cb.addRecipe(keyboard.next());
            } else if ("search".equals(cmd)) {
                System.out.print("Enter search string: ");
                cb.showRecipes(keyboard.next());
            } else if ("check".equals(cmd)) {
                checkRecipeExists(cb, keyboard);
            } else if ("save".equals(cmd)) {
                System.out.print("Enter cook book file name: ");
                cb.write(keyboard.next());
            } else if ("load".equals(cmd)) {
                System.out.print("Enter cook book file name: ");
                cb = CookBook.load(keyboard.next());
            }
        } while (!"quit".equals(cmd));
    }
}
