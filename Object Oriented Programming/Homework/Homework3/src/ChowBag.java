/** Chowbag class.
 * 
 * @author jacobigel
 *
 */
public class ChowBag extends Food {

    /**
     * Returns the price and weight of the food from the food class.
     * 
     * @param p - price of the food.
     * @param w - weight of the food.
     */
    public ChowBag(float p, float w) {
        super(p, w);

    }

    /** Returns the kind of the food. 
     * 
     */
    public String getKind() {
        return "ChowBag";
    }

    /** Returns the kind of the food, price, and weight in string format.
     * 
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "ChowBag", price, weight);
    }

    /** Returns if the food is aquatic.
     * 
     */
    public boolean isAquatic() {
        return false;
    }

}
