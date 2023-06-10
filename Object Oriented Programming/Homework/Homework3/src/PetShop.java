
/**
 * @author jacobigel
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
   

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = 
            "    Number of pets      : %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = 
            "Summary of items in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS =
            "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        int count = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Food) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        int count = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                count++;
            }
        }
        return count;
    }

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String type = sc.next();

            if (type.equals("Fish")) {
                things.add(new Fish(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (type.equals("Octopus")) {
                things.add(
                        new Octopus(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (type.equals("ChowBag")) {
                things.add(new ChowBag(sc.nextFloat(), sc.nextFloat()));
            } else if (type.equals("WormCan")) {
                things.add(new WormCan(sc.nextFloat(), sc.nextFloat()));
            } else if (type.equals("Dog")) {
                things.add(
                        new Dog(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (type.equals("Cat")) {
                things.add(
                        new Cat(sc.next(), sc.nextFloat(), sc.nextFloat()));
            }
        }
    }

    // total price of aquatic food
    protected float totalPriceFoodAq = 0;
    // total price of non-aquatic food
    protected float totalPriceFoodNonAq = 0;
    // total price of aquatic pets
    protected float totalPriceAq = 0;
    //// total price of non-aquatic pets
    protected float totalPriceNonAq = 0;
    // aquatic pet count
    protected int aquaticPetCount = 0;
    // aquatic food count
    protected int aquaticFoodCount = 0;

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                if (things.get(i).isAquatic()) {
                    aquaticPetCount++;
                    totalPriceAq += things.get(i).getPrice();
                } else {
                    totalPriceNonAq += things.get(i).getPrice();
                }

            } else {
                if (things.get(i).isAquatic()) {
                    aquaticFoodCount++;
                    totalPriceFoodAq += things.get(i).getPrice();
                } else {
                    totalPriceFoodNonAq += things.get(i).getPrice();
                }
            }
        }
        System.out.printf(SUMMARY_FORMAT, aquaticPetCount, totalPriceAq,
                aquaticFoodCount, totalPriceFoodAq,
                getPetCount() - aquaticPetCount,
                totalPriceNonAq, getFoodCount() - aquaticFoodCount,
                totalPriceFoodNonAq);
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        System.out.println("List of all items:");
        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i));
        }

    }

    // weight of aquatic food
    protected float foodWeightAq = 0;
    // weight of non-aquatic food
    protected float foodWeightNonAq = 0;
    // daily aquatic food
    protected float foodDailyAq = 0;
    // daily non-aquatic food
    protected float foodDailyNonAq = 0;

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Food) {
                Food other = (Food) things.get(i);
                if (other.isAquatic()) {
                    foodWeightAq += other.getWeight();

                } else {
                    foodWeightNonAq += other.getWeight();
                }
            } else if (things.get(i) instanceof Pet) {
                Pet other = (Pet) things.get(i);
                if (other.isAquatic()) {
                    foodDailyAq += other.getFoodPerDay();
                } else {
                    foodDailyNonAq += other.getFoodPerDay();
                }
            }
        }
        System.out.printf(FOOD_STATUS, foodDailyAq, foodDailyNonAq,
                foodWeightAq, foodWeightNonAq);
    }
}
