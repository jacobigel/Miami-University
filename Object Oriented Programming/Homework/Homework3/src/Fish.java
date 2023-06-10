/** Fish class.
 * @author jacobigel
 *
 */
public class Fish extends Pet {

    /**
     * This gets the kind, price and food per day from the Pet class.
     * 
     * @param k   - the kind
     * @param p   - the price
     * @param foodPerD - the food per day
     */
    public Fish(String k, float p, float foodPerD) {
        super(k, p, foodPerD);

    }

    /**
     * This returns Fish and the kind.
     */
    public String getKind() {
        return "Fish: " + this.kind;
    }

    /**
     * This gives a fish, kind, price, and food per day in string format.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Fish", kind, price,
                foodPerDay);
    }

    /**
     * Returns if it is aquatic or not.
     */
    public boolean isAquatic() {
        return true;
    }

}
