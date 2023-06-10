/**
 * This is the car class that tests some functionality with objects.
 * 
 * @author jacobigel
 * 
 */
public class Car {
    /**
     * This instance variable is used to maintain the make.
     */
    private String make;

    /**
     * This instance variable is used to track the distance (in miles) that a
     * car has traveled.
     */
    private int mileage;

    /**
     * This constructor should initialize the make and mileage of the Car object
     * to the corresponding values specified as parameters.
     * 
     * @param theMake - gets the make of the car.
     * @param theMileage - gets the mileage of the car
     */
    public Car(String theMake, int theMileage) {
        this.make = theMake;
        this.mileage = theMileage;
    }

    /**
     * This constructor should initialize the make to the value supplied as
     * parameter and initialize mileage to zero.
     * 
     * @param theMake - gets the make of the car.
     */
    public Car(String theMake) {
        this.make = theMake;
        this.mileage = 0;
    }

    /**
     * Returns the make of the car.
     * 
     * @return the make of the car
     */
    public String getMake() {
        return this.make;
    }

    /**
     * Return the mileage of the car.
     * 
     * @return the mileage of the car
     */
    public int getMileage() {
        return this.mileage;
    }

    /**
     * This adds the given distance to the current mileage of the Car.
     * 
     * @param distance the mileage + the added distance
     */
    public void drive(int distance) {
        this.mileage = Math.abs(distance) + mileage;
    }

    /**
     * This gives the car make and "honks" the horn by adding beep.
     */
    public void honkHorn() {
        System.out.println(this.make + ": beep");
    }

    /**
     * This returns the make and mileage and prints it as a string when called
     * elsewhere.
     */
    public String toString() {
        return this.make + ": " + this.mileage;
    }

}
