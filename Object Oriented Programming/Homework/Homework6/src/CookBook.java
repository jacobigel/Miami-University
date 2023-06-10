import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * A CookBook class that consists of an array of Recipe objects. This class
 * provides some utility methods to aid use of this CookBook.
 * 
 * @author Jacob Igel
 *
 */
public class CookBook implements Serializable {
    /**
     * The serialization UID used for writing objects.
     */
    private static final long serialVersionUID = 5254752840087680253L;

    /**
     * The array of recipes that constitute this cook book.
     */
    Recipe[] recipes = null;

    /*-----------------------------------------------------*/
    /* YOU CANNOT ADD ANY ADDITIONAL INSTANCE VARIABLES */
    /*-----------------------------------------------------*/

    /**
     * The default constructor that merely sets the recipes array to an empty
     * array with zero elements in the recipes array.
     */
    public CookBook() {
        recipes = new Recipe[0];
    }

    // -------------------------------------------------------------------
    // The following methods must be implemented by students
    // -------------------------------------------------------------------

    /**
     * Load a CookBook object from a given binary file that was previously
     * created by a call to write method. If an error occurs when loading the
     * file then this method returns null. The exception generated is printed
     * with the message "Unable to load cookbook because:\n" + e.getMessage()
     * 
     * @param fileName The name of the file from where the a CookBook is to be
     *                 loaded.
     * 
     * @return Returns a newly loaded CookBook object from a given file. If an
     *         error occurs then this method displays the exception and returns
     *         null.
     */
    public static CookBook load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (CookBook) ois.readObject();
        } catch (Exception e) {
            System.out.println(
                    "Unable to load cookbook because:\n" + e.getMessage());
            return null;
        }
    }

    /**
     * This method can be used to write the current cook book with the current
     * set of recipes to a given file. The exception generated is printed with
     * the message "Unable to write cookbook because:\n" + e.getMessage()
     * 
     * @param fileName The file name to which this cook book must be saved.
     */
    public void write(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(this);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to write cookbook because:\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println(
                    "Unable to write cookbook because:\n" + e.getMessage());
        }
    }

    /**
     * This method loads a recipe from a given text file and adds them to the
     * recipes array in this CookBook. The exception generated is printed with
     * the message "Unable to load recipe because:\n" + e.getMessage()
     * 
     * @param fileName The text file from where the recipe is to be loaded.
     */
    public void addRecipe(String fileName) {
        try {
            Recipe r = Recipe.createRecipe(fileName);

            Recipe[] copy = Arrays.copyOf(recipes, recipes.length + 1);
            copy[recipes.length] = r;
            recipes = copy;

            System.out.println("Recipe " + r.getName() + " added.");

        } catch (Exception e) {
            System.out.println(
                    "Unable to load recipe because:\n" + e.getMessage());
        }
    }

    /**
     * This method searches each recipe in the recipes (instance variable) array
     * for the given String s (using the hasString method) and prints recipes
     * that have the string s.
     * 
     * @param s The string to search for.
     */
    public void showRecipes(String s) {
        boolean found = true;
        for (Recipe r : recipes) {
            if (r.hasString(s)) {
                found = false;
                System.out.println(r);
            }
        }

        if (found) {
            System.out.println("No matching recipes found.");
        }
    }

    /**
     * This method searches the set of recipes in this cook book to determine if
     * the given recipe exists in the cook book.
     * 
     * @param r The recipe to search for.
     * 
     * @return This method returns true if the recipe was found. Otherwise this
     *         method returns false.
     */
    public boolean hasRecipe(Recipe r) {
        for (int i = 0; i < recipes.length; i++) {
            if (recipes[i].toString().contains(r.toString())) {
                return true;
            }
        }
        return false;
    }
}
