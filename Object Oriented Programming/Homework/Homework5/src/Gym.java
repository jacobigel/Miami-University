import java.util.Scanner;

/**
 * 
 */

/**
 * @author jacobigel
 *
 */
public class Gym {
    Scanner sc = new Scanner(System.in);

    protected String gym;
    protected boolean pool;
    protected boolean lockerRoom;

    public static String hoursOfOpRec = "Miami Recreation Center\n"
            + "M:\t 6 AM - 11 PM\n"
            + "T:\t 6 AM - 11 PM\n"
            + "W:\t 6 AM - 11 PM\n"
            + "TH:\t 6 AM - 11 PM\n"
            + "F:\t 6 AM - 10 PM\n"
            + "SAT:\t 8 AM - 10 PM\n"
            + "SUN:\t 10 AM - 10 PM\n";

    public static String hoursOfOpChestnut = "Chestnut Field House\n"
            + "M:\t 7 AM - 6:45 PM\n"
            + "T:\t 4 PM - 6:15 PM\n"
            + "W:\t 6 AM - 11 PM\n"
            + "TH:\t 6 AM - 11 PM\n"
            + "F:\t 6 AM - 10 PM\n"
            + "SAT:\t 8 AM - 10 PM\n"
            + "SUN:\t 10 AM - 10 PM\n";

    public static String hoursOfOpNorth = "North Quad Fitness Center\n"
            + "M:\t 3 PM - 9 PM\n"
            + "T:\t 3 PM - 9 PM\n"
            + "W:\t 3 PM - 9 PM\n"
            + "TH:\t 3 PM - 9 PMM\n"
            + "F:\t 3 PM - 6 PM\n"
            + "SAT:\t CLOSED\n"
            + "SUN:\t 4 PM - 9 PM\n";

    /**
     * Constructor for gym class.
     * 
     * @param g    - gym
     * @param p    - pool
     * @param lock - locker rooms
     */
    public Gym(String g, boolean p, boolean lock) {
        gym = g;
        pool = p;
        lockerRoom = lock;

    }

    /**
     * Returns the hours of operation of everyday of the week at the recreation
     * center.
     * 
     */
    public void gymHours() {
        System.out.println("Which gym are you trying to go to (1 - 3)?\n"
                + "1. Miami Recreation Center\n"
                + "2. Chestnut Field House\n"
                + "3. North Quad Fitness Center\n");
        int gym = sc.nextInt();
        if (gym == 1) {
            System.out.printf("Here are the hours for the %s", hoursOfOpRec);
            setGym("Miami Recreation Center");
            lockerRoom = isLocker();
            pool = isPool();
        } else if (gym == 2) {
            System.out.printf(hoursOfOpChestnut);
            setGym("Chestnut Field House");
            lockerRoom = isLocker();
        } else if (gym == 3) {
            System.out.printf(hoursOfOpNorth);
            setGym("North Quad Fitness Center");
            lockerRoom = isLocker();
        } else {
            System.out.print("This Gym isn't available");
        }

    }

    /**
     * Getter for the gym.
     * 
     * @return which gym the user is at.
     */
    public String getGym() {
        return gym;

    }

    /**
     * Mehtod to set the gym.
     * 
     * @param i - which gym they are at
     * @return The name of the gym
     */
    public String setGym(String i) {
        return i = this.gym;
    }

    /**
     * Seeing if there is a locker room.
     * 
     * @return true if locker room
     */
    public boolean isLocker() {
        return true;
    }

    /**
     * Seeing if there is a pool at the gym.
     * 
     * @return - true if there is a pool
     */
    public boolean isPool() {
        return true;
    }

    /**
     * Turning the constructor into a string format.
     */
    public String toString() {
        return ("You are going to " + this.getGym() + ".\n"
                + "Is there a pool here?: " + isPool() + "\n"
                + "Do they have locker rooms?: " + isLocker());
    }

    /**
     * Method to ask the user about how much time they spent in the gym.
     */
    public void gymTime() {
        System.out.println(
                "About how long do you expect to be in the gym (in minutes)?");
        float time = sc.nextFloat();
        if (time <= 30) {
            System.out.println("A short workout never hurt anyone!");
        } else if (time > 30 || time <= 45) {
            System.out.println("Must be on a tight schedule today!");
        } else if (time > 45 || time <= 60) {
            System.out.println(
                    "Make sure the next time you go, you stay"
                            + " for a little longer!");
        } else if (time > 60 || time <= 90) {
            System.out.println(
                    "Make sure to get a bit of cardio in before you leave!");
        } else {
            System.out.println(
                    "Man thats a long time! Be safe and make sure to rest!");
        }

    }

    /**
     * Method to print a few statements about how many days it has been since
     * the user has been at the gym.
     */
    public void daySince() {
        System.out.println(
                "About how has it been since youve been to the gym (in days)?");
        float time = sc.nextFloat();
        if (time <= 1) {
            System.out.println("Woah! Make sure you're taking time to rest");
        } else if (time > 1 || time <= 3) {
            System.out
                    .println("Make sure you are drinking water and streching");
        } else if (time > 3 || time <= 5) {
            System.out.println("A few days to relax never killed anyone");
        } else if (time > 5 || time <= 7) {
            System.out.println("Hey, sometimes you need a break!");
        } else {
            System.out.println("Man thats a long time! Have fun!");
        }
    }

}
