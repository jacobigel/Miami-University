import java.io.Serializable;

/**
 * @author Jacob Igel
 */
/**
 * This class represents an ingredient that can be used to make a nice Recipe.
 * An ingredient object holds the following information:
 * <ol>
 * <li>1. Quantity of ingredient.</li>
 * <li>2. The measurement unit (like: cup, grams, etc.)</li>
 * <li>3. The description of the ingredient.</li>
 * </ol>
 */
public class Ingredient implements Cloneable, Serializable {
    /**
     * The serialization UID that is used when writing objects to file.
     */
    private static final long serialVersionUID = 1272271655282280842L;

    /**
     * The quantity of ingredient.
     */
    private double quantity = 1.0;

    /**
     * The measurement unit for this ingredient.
     */
    private String measurement = "";

    /**
     * An optional description for this ingredient.
     */
    private String description = "";

    /**
     * A fixed error message included in exceptions.
     */
    private static final String EXP_MSG = "Each ingredient line must be of the "
            + "form:\nquantity ; measurement; description";

    /*-----------------------------------------------------*/
    /* YOU CANNOT ADD ANY ADDITIONAL INSTANCE VARIABLES */
    /*-----------------------------------------------------*/

    /**
     * This creates an ingredient with the specific values.
     * 
     * @param quantity    The quantity of the ingredient
     * @param measurement The measurement of the ingredient
     * @param description The description of the ingredient
     * 
     * @throws IllegalArgumentException if quantity <0 or either String value is
     *                                  null
     */
    public Ingredient(double quantity, String measurement, String description) {
        setQuantity(quantity);
        setMeasurement(measurement);
        setDescription(description);
    }

    /**
     * This sets an ingredients quantity to a specific value. The parameter
     * should be greater than 0. This method is protected, because this should
     * not be changed outside of the class.
     * 
     * @param newQuantity The new quantity for the recipe.
     * @throws IllegalArgumentException If newQuantity is <= 0.
     */
    protected void setQuantity(double newQuantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
        quantity = newQuantity;
    }

    /**
     * This sets an ingredient's measurement to a specific value. The parameter
     * should not be null. This method is protected, because this should not be
     * changed outside of the class.
     * 
     * @param newMeasurement The new measurement
     * @throws IllegalArgumentException If newMeasurement is null
     */
    protected void setMeasurement(String newMeasurement) {
        if (newMeasurement == null) {
            throw new IllegalArgumentException();
        }
        measurement = newMeasurement;
    }

    /**
     * This sets an ingredient's description to a specific value. The parameter
     * should not be null. This method is protected, because this should not be
     * changed outside of the class.
     * 
     * @param newDescription The new description
     * @throws IllegalArgumentException If newDescription is null
     */
    protected void setDescription(String newDescription) {
        if (newDescription == null) {
            throw new IllegalArgumentException();
        }
        description = newDescription;
    }

    /**
     * Returns true if the ingredient's descriptions contains term anywhere in
     * the description.
     * 
     * @note For checking, the lower case version of both the term and
     *       description is used.
     *
     * @see String.toLowerCase
     * @see String.contains
     * 
     * @param term The search term
     * @return true if the term is in the ingredient's description
     */
    public boolean searchForTerm(String term) {
        return this.description.toLowerCase().contains(term.toLowerCase());
    }

    /**
     * Getter for quantity.
     * 
     * @return quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Getter for measurement.
     * 
     * @return Measurement
     */
    public String getMeasurement() {
        return measurement;
    }

    /**
     * Getter for description.
     * 
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return quantity + " " + measurement + " " + description;
    }

    /**
     * Internal helper method to rethrow exception as an invalid ingredient
     * exception.
     * 
     * @param e        The exception to be processed by this method.
     * @param line     The line that caused an error.
     * @param quantity The quantity read from the line.
     * @throws InvalidIngredientException This method rethrows the exception.
     */
    private static void rethrow(IllegalArgumentException e, String line,
            double quantity) throws InvalidIngredientException {
        if (quantity < 0) {
            throw new InvalidIngredientException(
                    "Quantity of line \"" + line + "\" is negative");
        } else {
            throw new InvalidIngredientException("Could not parse \"" + line
                    + "\" and I do not know why");
        }
    }

    // -------------------------------------------------------------------
    // The following methods must be implemented by students
    // -------------------------------------------------------------------

    /**
     * Takes a string of the form "quantity; measurement; description" and makes
     * an ingredient out of it (using helper methods).
     * 
     * @param line The line of text that describes the ingredient
     * @return The ingredient for the line.
     * 
     * @throws InvlaidIngredientException If the line cannot be parsed
     */
    public static Ingredient parseString(String line)
            throws InvalidIngredientException {
        String[] ingredientList = line.split(";");

        if (ingredientList.length == 1) { 
            throw new InvalidIngredientException(EXP_MSG);
        }
        double quantity = 1.0;
        if (ingredientList[0].length() > 0) {
            quantity = Double.parseDouble(ingredientList[0].strip());
        }

        String measurement = ingredientList[1].strip();
        String description = ingredientList[2].strip();

        return new Ingredient(quantity, measurement, description);
    }

    /**
     * Compares two Ingredient objects to determine if they are equal. Two
     * objects are equal if and only if their quantity, description, and
     * measurement are all equal.
     * 
     * @return Returns true if objects are equal. False otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != Ingredient.class) {
            return false;
        }

        Ingredient obj = (Ingredient) other;

        return (this.quantity == obj.quantity)
                && this.measurement.equals(obj.measurement)
                && this.description.equals(obj.description);

    }

    @Override
    public Ingredient clone() {
        return new Ingredient(this.quantity, this.measurement,
                this.description);
    }
}
