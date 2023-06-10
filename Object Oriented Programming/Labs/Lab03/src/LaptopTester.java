import java.util.ArrayList;

/**
 * A helper class to test the Laptop class with.
 * 
 * @author mamjad
 */
public class LaptopTester {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        System.out.println(l1.getBrand());
        System.out.println(l1.getYear());
        System.out.println(l1.getDetails());
        
        ArrayList<String> details2 = new ArrayList<String>();
        details2.add("CPU i9");
        details2.add("GPU 12 Core");
        details2.add("Nvidia Graphic");
        
        Laptop l2 = new Laptop("HP", 2022, details2);
        System.out.println(l2.getBrand());
        System.out.println(l2.getYear());
        System.out.println(l2.getDetails());
        
        l2.setBrand("Sony");
        
        System.out.println(l2.getBrand());
        System.out.println(l2.getYear());
        System.out.println(l2.getDetails());
        
        if (l2.isHighPerformance() && !l2.isOld()) {
            System.out.println("Good Laptop");
        } else {
            System.out.println("Not Good For Gaming!!");
        }
        
        
      
    }
}
