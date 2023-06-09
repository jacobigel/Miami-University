import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple employee class that can be read or written in binary format.
 */
public class Employee implements Serializable {
    /**
     * An serialization ID generated by Eclipse.
     */
    private static final long serialVersionUID = 6714812365672432585L;

    /**
     * An unique ID for each employee.
     */
    public int id;

    /**
     * Name of the employee. The name is assumed to be shorter than
     * 15-characters.
     */
    public String name;

    /**
     * The salary for the employee rounded to the nearest dollar.
     */
    public int salary;

    /**
     * A simple constructor to create employee objects.
     * 
     * @param id     The ID to be associated with the employee.
     * @param name   The name of the employee.
     * @param salary The salary for the employee.
     */
    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%2d, %-15s, %6d", id, name, salary);
    }

    /**
     * Helper method to load employee data from a given text file and return the
     * information as an array of Employee objects.
     * 
     * @param txtFileName Path to the CSV file from where employee data is to be
     *                    read.
     * @return An array of Employee objects created using the data from the CSV
     *         file.
     * @throws FileNotFoundException Exposes exception.
     */
    public static Employee[] load(String txtFileName)
            throws FileNotFoundException {
        // Use a scanner to read line-by-line and use
        // String.split(",") to split data into 3 columns.

        // It would be easier to use an ArrayList and then
        // use ArrayList.toArray() method to return as array.

        Scanner sc = new Scanner(new File(txtFileName));

        ArrayList<Employee> empList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] vals = sc.nextLine().split(",");

            int id = Integer.parseInt(vals[0]);
            int salary = Integer.parseInt(vals[2]);

            empList.add(new Employee(id, vals[1], salary));
        }

        return empList.toArray(new Employee[0]);
    }

    /**
     * Writes the supplied array to a given file in binary format using an
     * ObjectOutputStream.
     * 
     * @note This method should not have any loops
     * 
     * @param outFileName Path to the output file.
     * @param list        The array of employees to be written
     * @throws IOException Exceptions may be throws due to I/O errors.
     */
    public static void writeAsBinary(String outFileName, Employee[] list)
            throws IOException {
        // Write the whole array. This method should not have any loops
        // It is just a few lines of code.

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(outFileName))) {

            oos.writeObject(list);

            oos.close();
        }

    }

    /**
     * Reads an array of employees from a binary file using an
     * ObjectInputStream.
     * 
     * @note This method assumes that the binary data has been written using the
     *       writeAsBinary method in this class.
     * 
     * @param inFileName The binary file from where data is to be read.
     * @return An array of Employee objects read from the file.
     * @throws IOException            Exceptions may be throws due to I/O
     *                                errors.
     * @throws ClassNotFoundException If object was not array of Employee
     */
    public static Employee[] readAsBinary(String inFileName)
            throws IOException, ClassNotFoundException {
        // Read a whole array. This method should not have any loops
        // This is just a few lines of code.

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(inFileName))) {
            return (Employee[]) ois.readObject();
        }

    }
}
