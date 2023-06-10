/**
 * This is a simple interface that is implemented by all controllable devices.
 * Controllable devices can essentially be turned on by calling the on() method.
 * Devices that are turned on() can be turned off via the off() method.
 * 
 * @author Jacob Igel
 *
 */
public interface Controllable {
    /**
     * This method can be used to turn-on a device that is currently in the off
     * position. Calling this method on a device that is already turned on has
     * no impact.
     */
    public void on();

    /**
     * This method can be used to turn-off a device that is currently turned on.
     * Calling this method on a device that is already off has no impact.
     */
    public void off();
}
