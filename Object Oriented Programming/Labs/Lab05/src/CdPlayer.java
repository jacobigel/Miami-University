/**
 * This is a simple light bulb class that can be turned on or turned off. The
 * light bulb is a very simple device and implements just the Controllable
 * interface.
 *
 */
public class CdPlayer implements RemoteControl {
    /**
     * This instance variable stores the name set for the cd player.
     */
    private String name;

    /**
     * The constructor for the cd player class. Specify the name to be set for
     * this cd player as the parameter.
     * 
     * @param name The name to be set for this light bulb.
     */
    public CdPlayer(String name) {
        this.name = name;
    }

    /**
     * This method implements the play() method in the RemoteControl interface.
     * It simply prints that it is playing music.
     */
    public void play() {
        System.out.println(name + ": Playing music.");
    }

    /**
     * This method implements the stop() method in the RemoteControl interface.
     * It simply prints that it is stopping music.
     */
    public void stop() {
        System.out.println(name + ": Stopping music.");
    }

    @Override
    public void on() {
        System.out.println(name + ": CD Player is on");
    }

    @Override
    public void off() {
        System.out.println(name + ": CD Player is off");
    }


}
