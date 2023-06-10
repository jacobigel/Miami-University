import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author jacobigel
 *
 */
public class Workout extends Gym {
    protected int sets;
    protected int reps;
    protected int weight;

    protected ArrayList<String> exercisesPull = new ArrayList<>();
    protected ArrayList<String> exercisesPush = new ArrayList<>();
    protected ArrayList<String> exercisesLeg = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    /**
     * A constructor to establish the amount of sets, reps, and weights
     * 
     * @param s - sets
     * @param r - reps
     * @param w - weight to use
     */
    public Workout(int s, int r, int w) {
        super("Miami Recreation Center", true, true);
        sets = s;
        reps = r;
        weight = w;

    }

    /**
     * A method to add an exercise to a list.
     * 
     * @param exercise - add to pull exercise list
     * @return - pull exercises
     */
    public ArrayList<String> addExercisePull(String exercise) {
        exercisesPull.add(exercise);
        return exercisesPull;
    }

    /**
     * A method to add an exercise to a list.
     * 
     * @param exercise - add to push exercise list
     * @return - push exercises
     */
    public ArrayList<String> addExercisePush(String exercise) {
        exercisesPush.add(exercise);
        return exercisesPush;
    }

    /**
     * A method to add an exercise to a list.
     * 
     * @param exercise - add to leg exercise list
     * @return - leg exercises
     */
    public ArrayList<String> addExerciseLeg(String exercise) {
        exercisesLeg.add(exercise);
        return exercisesLeg;
    }

    /**
     * A list of all pull exercises.
     */
    public void pullList() {
        int i = 1;
        for (String workout : exercisesPull) {
            System.out.println(i++ + ". " + workout);
        }
    }

    /**
     * A list of all push exercises.
     */
    public void pushList() {
        int i = 1;
        for (String workout : exercisesPush) {
            System.out.println(i++ + ". " + workout);
        }
    }

    /**
     * A list of all leg exercises.
     */
    public void legList() {
        int i = 1;
        for (String workout : exercisesLeg) {
            System.out.println(i++ + ". " + workout);
        }
    }

    /**
     * Returns the one-rep max you can lift.
     * 
     * @param w - weight
     * @param r - reps
     * @return a double value one-rep max
     */
    public double maxRep(int w, int r) {
        return w * (r * (.33 + 1));
    }

    /**
     * Method to give the the preferred protein in-take
     * 
     * @param bodyWeight - body weight you have
     * @return - returns the preferred body weight in-take
     * 
     */
    public double proteinIn(double bodyWeight) {
        return 2.4 * bodyWeight;
    }

    /**
     * returning the sets, reps, and weight to string format
     */
    @Override
    public String toString() {
        return (this.getSets() + " sets of " + this.getReps() + " reps done at "
                + this.getWeight() + " pounds - good work!");
    }

    /**
     * Get the amount of sets
     * 
     * @return - int of sets
     */
    public int getSets() {
        return sets;

    }

    /**
     * Setting the number of sets.
     * 
     * @param s - sets
     * @return - setting the number of sets
     */
    public int setSets(int s) {
        return s = this.sets;
    }

    /**
     * Getting the number of reps.
     * 
     * @return - int of reps
     */
    public int getReps() {
        return reps;

    }

    /**
     * Setting the amount of reps
     * 
     * @param r - reps
     * @return int of reps
     */
    public int setReps(int r) {
        return r = this.reps;
    }

    /**
     * Getting the amount of weight.
     * 
     * @return - int of weight used
     */
    public int getWeight() {
        return weight;

    }

    /**
     * Sets the amount of weight used.
     * 
     * @param w - weight
     * @return - amount of set weight
     */
    public int setWeight(int w) {
        return w = this.weight;
    }

}
