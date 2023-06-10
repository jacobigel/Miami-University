/** Food class.
 * @author jacobigel
 *
 */
public class Food extends Thing {
    // shows how much the pet costs
    protected float price;
    // shows how much the food weighs
    protected float weight;

    /**
     * Puts the price and weight into this.
     * 
     * @param p - shows price variable
     * @param w - shows weight variable
     */
    public Food(float p, float w) {
        price = p;
        weight = w;
    }

    /**
     * Returns the price of food.
     * 
     * @return - returns the price variable
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the weight of the food.
     * 
     * @return - returns the weight variable
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Two Food objects are equal only if they are of the same Java-class and
     * have the same price and weight.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Food)) {
            return false;
        }
        
        Food f = (Food) obj;
        //compare price object to price and weight obj to weight 
        return (f.getPrice() == this.price && f.getWeight() == this.weight);
    

    }
    
}
