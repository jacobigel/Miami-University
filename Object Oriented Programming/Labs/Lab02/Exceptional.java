/**
 * A simple Java program to observe propagation of exceptions via
 * the call stack. 
 * 
 * @author raodm
 *
 */
public class Exceptional {

    /**
     * Just a simple method to test propagation of exceptions in Java.
     * 
     * @param i A parameter to trigger exceptions.
     */
    public static void four(int i) {
        System.out.println("Running method four(" + i + ")");
        try {
            if (i % 2 == 0) {
                throw new RuntimeException("even number");
            }
            System.out.println(i + " is odd.");
        } finally {
            System.out.println("Done with four(" + i + ")");
        }
    }
    
    /**
     * Just a pass through method to test propagation of exceptions in Java.
     * 
     * @param i A parameter to trigger exceptions.
     */
    public static void three(int i) {
        System.out.println("Running method three(" + i + ")");
        // Just a simple method call
        four(i);
        System.out.println("Done with three(" + i + ")");
    }
    
    /**
     * This is just a simple method to test exception handling in Java.
     * 
     * @param i A parameter to test operation of methods.
     */
    public static void two(int i) {
        try {
            System.out.println("Running method two(" + i + ")");
            three(i - 1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("Done with phase #1 of two(" + i + ")");
        }
        // Another attempt
        try {
            three(i);
        } finally {
            System.out.println("Done with phase #2 of two(" + i + ")");
        }
    }

    /**
     * This is just a simple method to test exception handling in Java.
     * 
     * @param i A parameter to test operation of methods.
     */
    public static void one(int i) {
        try {
            System.out.println("Running method one(" + i + ")");
            two(i - 1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A simple main method that is used for testing exception 
     * propagation in Java.
     * 
     * @param args Command-line arguments are not used.
     */
    public static void main(String[] args) {
        one(3);
    }
}
