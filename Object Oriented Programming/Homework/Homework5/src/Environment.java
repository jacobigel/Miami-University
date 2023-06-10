import java.util.Scanner;

/**
 * 
 */

/**
 * @author jacobigel
 *
 */
public class Environment extends Workout {

    Scanner sc = new Scanner(System.in);

    protected String music;
    protected String weather;

    /**
     * Constructor for Environment class.
     * 
     * @param m - music type
     * @param w - weather
     */
    public Environment(String m, String w) {
        super(0, 0, 0);
        m = this.music;
        w = this.weather;

    }

    /**
     * Seeing is the user is working out inside or outside.
     */
    public void inOrOut() {
        System.out.println("Are you working out inside or outside?\n"
                + "1.\t Inside\n"
                + "2.\t Outside\n");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Inside? Nice! Hopefully there is AC!");
        } else if (choice == 2) {
            weather = whatWeather(sc.nextInt());
            System.out.println();
        } else {
            System.out.println("Not a valid selection.");
            ;
        }

    }

    /**
     * Seeing what weather the user is working out in.
     * 
     * @param wther - weather
     * @return the type of weather
     */
    public String whatWeather(int wther) {
        String currentWeather = "";
        System.out.println("How is the Weather?\n"
                + "1.\t Clear\n"
                + "2.\t Rainy\n"
                + "3.\t Snowing\n"
                + "4.\t Foggy\n"
                + "5.\t Other\n");

        if (wther == 1) {
            return currentWeather = "Clear";
        } else if (wther == 2) {
            return currentWeather = "Rainy";
        } else if (wther == 3) {
            return currentWeather = "Snowing";
        } else if (wther == 4) {
            return currentWeather = "Foggy";
        } else {
            return currentWeather = "Other";
        }

    }

    /**
     * Selection for the users music during the work out.
     * 
     * @param music - music for the user
     * @return genre of the music that will play next
     */
    public String musicSelector(int music) {
        String upNext = "";
        if (music == 1) {
            return upNext = "Metal";
        } else if (music == 2) {
            return upNext = "Rock & Roll";
        } else if (music == 3) {
            return upNext = "Rap";
        } else if (music == 4) {
            return upNext = "Trap";
        } else {
            return upNext = "Random";
        }
    }

    /**
     * Getting the type of weather.
     * 
     * @return - String of weather
     */
    public String getWeather() {
        return weather;

    }

    /**
     * Setting the weather.
     * 
     * @param wther - weather
     * @return string of weather
     */
    public String setWeather(String wther) {
        return wther = this.weather;
    }

    /**
     * Getting the type of music.
     * 
     * @return - String of music
     */
    public String getMusic() {
        return music;

    }

    /**
     * Setting the music.
     * 
     * @param m - music
     * @return string of music
     */
    public String setMusic(String m) {
        return m = this.music;
    }

}
