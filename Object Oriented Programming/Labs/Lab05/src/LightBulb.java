/**
 * This is a simple light bulb class that can be turned on or turned off. The
 * light bulb is a very simple device and implements just the Controllable
 * interface.
 *
 */
public class LightBulb implements Controllable {
    /**
     * This instance variable stores the name set for the light bulb.
     */
    private String name;

    /**
     * The constructor for the light bulb class. Specify the name to be set for
     * this light bulb as the parameter.
     * 
     * @param name The name to be set for this light bulb.
     */
    public LightBulb(String name) {
        this.name = name;
    }

    /**
     * Tis method implements the on() method in the Controllable interface. It
     * simply prints that the light bulb in on.
     */
    public void on() {
        System.out.println(name + ": Light bulb is on");
    }

    @Override
    public void off() {
        System.out.println(name + ": Light bulb is off");

    }
}
