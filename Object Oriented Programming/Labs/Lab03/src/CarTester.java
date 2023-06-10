/**
 * @author jacobigel
 */

/**
 * This class is a Unit testing class in which tests are to be added as features
 * are added to the Car class.
 */
public class CarTester {
    /**
     * The main method that is used to test the operations of the Car class.
     * 
     * @param args The arguments are currently not used.
     */
    public static void main(String[] args) {
        // AFTER writing your constructors...
        // Create a car using the two-parameter constructor
        // (make it a Toyota-Corolla with 10000 miles)
        Car c1 = new Car("Toyota-Corolla", 10000);

        // Create a car using the one-parameter constructor
        // (make it a Ford)
        Car c2 = new Car("Ford");
        // ------------------------------------------------
        // AFTER writing your getter methods ...
        // Print the make and mileage for each car:
        System.out.println(c1.getMake() + " " + c1.getMileage());
        System.out.println(c2.getMake() + " " + c2.getMileage());

        // ------------------------------------------------
        // AFTER writing the drive method ...
        // drive the first car FORWARD 223 miles
        c1.drive(223);
        // drive the second car BACKWARD 20556 miles
        c2.drive(-205556);
        // THEN, print the mileage of each car to verify
        // that it changed correctly.
        System.out.println(c1.getMileage());
        System.out.println(c2.getMileage());
        // ------------------------------------------------
        // AFTER writing the honkHorn() method ...
        // make each car honk its horn.
        c1.honkHorn();
        c2.honkHorn();
        // ------------------------------------------------
        // AFTER writing the toString() method in Task #5...
        // print the toString() for each car.
        System.out.println(c1.toString());
        System.out.println(c2.toString());

    }
}
