/**
 * This class represents a simple living room that consists of several devices.
 * The main method creates various devices and adds it to the deviceList array
 * in this class.
 * 
 * @author Jacob Igel
 *
 */
public class LivingRoom {
    /**
     * The array list that contains the devices in this room.
     */
    private Controllable[] deviceList;

    /**
     * The constructor creates a set of devices and adds them to the deviceList.
     * The type of device to be created is obtained as a a variable number of
     * argument parameter.
     */
    public LivingRoom(int... deviceIds) {
        deviceList = new Controllable[deviceIds.length];
        for (int i = 0; (i < deviceIds.length); i++) {
            switch (deviceIds[i]) {
            case 1:
                deviceList[i] = new LightBulb("Light" + i);
                break;
            case 2:
                deviceList[i] = new CdPlayer("Player" + i);
                break;
            default:
                throw new IllegalArgumentException("Invalid device");
            }
        }
    }

    /**
     * This method must perform the following tasks: 1. Iterate over the devices
     * in the deviceList 1.1. Turn on all the devices (via RemoteControl
     * interface) 1.2. Play devices that can be played.
     */
    public void on() {
        for (Controllable device : deviceList) {

            device.on();
            if (device instanceof RemoteControl) {

                RemoteControl rc = (RemoteControl) device;
                rc.play();

            }

        }
    }

    /**
     * This method must perform the following tasks: 1. Iterate over the devices
     * in the deviceList 1.1. Stop devices that can be stopped (via
     * RemoteControl interface) 1.2. Turn off the device (via the Controllable
     * interface)
     */
    public void off() {
        for (Controllable device : deviceList) {

            
            if (device instanceof RemoteControl) {

                RemoteControl rc = (RemoteControl) device;
                rc.stop();

            }
            device.off();
        }
    }

    /**
     * The main method creates various devices and adds it to the deviceList
     * array in this class.
     * 
     * @param args The command-line arguments are not really used.
     */
    public static void main(String[] args) {
        LivingRoom room1 = new LivingRoom(1, 1, 2);
        System.out.println("* * *    Testing 1    * * *");
        System.out.println("----[  Turning devices on  ]----");
        room1.on();
        System.out.println("----[  Turning devices off  ]----");
        room1.off();

        System.out.println("\n* * *    Testing 2    * * *");
        LivingRoom room2 = new LivingRoom(1, 2, 1, 1);
        System.out.println("----[  Turning devices on  ]----");
        room2.on();
        System.out.println("----[  Turning devices off  ]----");
        room2.off();
    }
}
