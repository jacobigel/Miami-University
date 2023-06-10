import java.util.Scanner;

/**
 * A simple class to test the basic operations of the Ingredient and Recipe
 * class.
 *
 * @author raodm
 *
 */
public class Phase1Tester {
    /**
     * Constant to account for rounding error in doubles.
     */
    private static final double EPSILON = 1e-6;

    /**
     * Simple method to check if instance variables in an Ingredient object have
     * expected values.
     * 
     * @param ing         The ingredient object being checked.
     * @param quantity    Expected quantity value.
     * @param measurement Expected measurement.
     * @param description Expected description.
     * @throws InvalidIngredientException Thrown if any of the ingrident's
     *                                    values did not match the expected
     *                                    values.
     */
    private static void checkIngredient(Ingredient ing, double quantity,
            String measurement, String description)
            throws InvalidIngredientException {
        boolean sameQuant = Math.abs(ing.getQuantity() - quantity) < EPSILON;
        if (!sameQuant || !measurement.equals(ing.getMeasurement())
                || !description.equals(ing.getDescription())) {
            throw new InvalidIngredientException(ing.toString()
                    + " did not have expected quntity, unit, or description.");
        }
    }

    /**
     * Helper method to test if the string parsing method in Ingredient. This
     * method checks to see if the different combinations of ingredients are
     * correctly parsed.
     * 
     * @throws InvalidIngredientException If parsing is not correct.
     */
    public static void testIngredientParsing()
            throws InvalidIngredientException {
        System.out.println("Testing Ingredient.parseString method...");

        // Test first combination.
        Ingredient ing = Ingredient.parseString(".5; cup; All Purpose Flour");
        checkIngredient(ing, 0.5, "cup", "All Purpose Flour");

        // Test the second combination
        ing = Ingredient.parseString(";;beet");
        checkIngredient(ing, 1, "", "beet");

        // Test the third combination
        ing = Ingredient.parseString(";gallon; Milk");
        checkIngredient(ing, 1, "gallon", "Milk");

        System.out.println("Done.");
    }

    /**
     * Used to verify operation of Recipe.createRecipe() method. The
     * text file to be processed is obtained as input from the user.
     * 
     * @throws Exception On I/O or parsing errors.
     */
    public static void testRecipeCreation() throws Exception {
        System.out.print("Enter recipe file name: ");
        try (Scanner sc = new Scanner(System.in)) {
            String fileName = sc.next();
            System.out.println("Loading recipe from " + fileName);
            Recipe rep = Recipe.createRecipe(fileName);
            System.out.println("Recipe loaded: ");
            System.out.println(rep);
        }
    }

    /**
     * The main method just calls other helper methods in this class.
     * 
     * @param args The command-line arguments are not used.
     * 
     * @throws Exception Exposes exceptions thrown by the tester methods.
     */
    public static void main(String[] args) throws Exception {
        // Test ingredient parsing.
        testIngredientParsing();
        // Test recipe loading
        testRecipeCreation();
    }
}
