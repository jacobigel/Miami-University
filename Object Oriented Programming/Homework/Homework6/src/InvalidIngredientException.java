
/**
 * This exception is for when an ingredient line cannot be parsed into a valid
 * ingredient.
 *
 */
public class InvalidIngredientException extends Exception {

    /**
     * For serialization purposes.
     */
    private static final long serialVersionUID = 5851465924234394151L;

    /**
     * This creates an ingredient with a specific message.
     * 
     * @param message The reason the ingredient could not be parsed
     */
    public InvalidIngredientException(String message) {
        super(message);
    }
}
