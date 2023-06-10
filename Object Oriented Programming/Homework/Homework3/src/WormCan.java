/** Worm class.
 * @author jacobigel
 *
 */
public class WormCan extends Food {

    /**
     * Returns the price and weight of the food from the food class.
     * 
     * @param p - price of the food.
     * @param w - weight of the food.
     */
    public WormCan(float p, float w) {
        super(p, w);
    }

    /**
     * Returns the kind of the food.
     */
    public String getKind() {
        return "WormCan";
    }

    /**
     * Returns the kind of the food, price, and weight in string format.
     * 
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "WormCan", price, weight);
    }

    /**
     * Returns if the food is aquatic.
     * 
     */
    public boolean isAquatic() {
        return true;
    }

}
