/**
 * Pet class.
 * 
 * @author jacobigel
 *
 */
public class Pet extends Thing {
    // sees what type of pet it is
    protected String kind;
    // shows how much the pet costs
    protected float price;
    // shows how much food is needed per day for the pet
    protected float foodPerDay;

    /**
     * This gets the kind, price and food per day.
     * 
     * @param k   - the kind
     * @param p   - the price
     * @param fPD - the food per day
     */
    public Pet(String k, float p, float foodPerD) {
        kind = k;
        price = p;
        foodPerDay = foodPerD;
    }

    /**
     * Returns the price variable.
     * 
     * @return - returns the price variable
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the food variable.
     * 
     * @return - returns the food per day
     */
    public float getFoodPerDay() {
        return foodPerDay;
    }

    /**
     * Two Pet objects are equal if they are of the same java-class and kind.
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pet)) {
            return false;
        }

        Pet p = (Pet) obj;
        return (p.kind.equals(this.kind));

    }

}
