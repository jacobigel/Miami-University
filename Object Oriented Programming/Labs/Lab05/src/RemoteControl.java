/**
 * This interface defines a remote control interface that enables controlling
 * selecting functionality of devices. This is a very simple interface that has
 * only 2 methods.
 * 
 * @author Jacob Igel
 *
 */
public interface RemoteControl extends Controllable {
    /**
     * This method can be used to request a device to start playing The device
     * decides what to play. A CDPlayer starts playing music. A DVD player may
     * start playing a DVD while a VCR may start playing a VHS tape.
     *
     */
    void play();

    /**
     * This method can be used to request a device to stop playing. If the
     * device is already stopped then invoking this method has no effect.
     */
    void stop();
}
