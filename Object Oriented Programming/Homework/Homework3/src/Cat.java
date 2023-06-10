/** Cat class.
 * @author jacobigel
 *
 */
public class Cat extends Pet {

    /**
     * This gets the kind, price and food per day from the Pet class.
     * 
     * @param k   - the kind
     * @param p   - the price
     * @param foodPerD - the food per day
     */
    public Cat(String k, float p, float foodPerD) {
        super(k, p, foodPerD);

    }

    /**
     * This returns Cat and the kind.
     */
    public String getKind() {
        return "Cat: " + this.kind;
    }

    /**
     * This gives a cat, kind, price, and food per day in string format.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Cat", kind, price,
                foodPerDay);
    }

    /**
     * Returns if it is aquatic or not.
     */
    public boolean isAquatic() {
        return false;
    }

}
