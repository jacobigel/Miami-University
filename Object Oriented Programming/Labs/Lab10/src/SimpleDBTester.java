import java.io.IOException;

/**
 * A simple test class to test the operation of methods in SimpleDB class.
 * 
 * @author raodm
 *
 */
public class SimpleDBTester {
    /**
     * The main method that performs some simple I/O operations.
     * 
     * @param args The command-line arguments are not used.
     */
    public static void main(String[] args) throws IOException {
        // Use a given binary file for testing.
        String path = (args.length > 0 ? args[0] : "simple_db.dat");
        
        // Open the database.
        SimpleDb db = new SimpleDb(path);

        // First test the read method to read and print a couple of records
        System.out.println("Record #4: " + db.read(4));
        System.out.println("Record #2: " + db.read(2));
        
        // Test the swap method.
        System.out.println("\nTesting swap method");
        db.swap(5,  7);
        System.out.println("Record #5: " + db.read(5));
        System.out.println("Record #7: " + db.read(7));
        
        // Test the sort method
        System.out.println("\nSorting & printing");
        db.sort();
        for (int i = 0; (i < db.getRecordCount()); i++) {
            System.out.println(db.read(i));
        }
    }
}
