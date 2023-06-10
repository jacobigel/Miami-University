import java.io.IOException;

/**
 * A simple test class to test the operation of methods in Employee class.
 * 
 * @author raodm
 *
 */
public class EmployeeTester {
    /**
     * Internal helper method to print an array of employees.
     * @param msg A given message to be printed first.
     * @param list The list of employees to be printed.
     */
    private static void print(String msg, Employee[] list) {
        System.out.println(msg);
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    /**
     * The main method that performs some simple I/O operations.
     * 
     * @param args The command-line arguments are not used.
     * @throws ClassNotFoundException Just exposes exception.
     */
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        // Load list of employees from text file.
        String txtPath = (args.length > 0 ? args[0] : "employee.txt");
        Employee[] list = Employee.load(txtPath);
        // Print the list of employees
        print("Data loaded from text file:", list);
 
        // Removing array entry 2 and 5
        Employee[] subList = new Employee[list.length - 2];
        for (int i = 0, dest = 0; (i < list.length); i++) {
            if (i != 2 && i != 5) {
                subList[dest++] = list[i];
            }
        }
        
        // Write the sub-list to disk as a binary file.
        System.out.println("\nWriting data to binary file...");
        Employee.writeAsBinary("employee2.dat", subList);
        System.out.println("Done.");
        
        // Read and print the binary file just created.
        Employee[] binList = Employee.readAsBinary("employee2.dat");
        print("\nData loaded from binary file:", binList);
    }
}
