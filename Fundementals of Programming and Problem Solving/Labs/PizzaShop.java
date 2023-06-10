/**
 * Jacob Igel
 * PizzaShop.java
 * Practicing writing and calling methods.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class PizzaShop {
    public static void main(String[] args) throws FileNotFoundException { 
    
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter order filename: ");
        String fileName = kb.next();
        pizzaOrder(fileName);
  
    } //main
    
    public static void pizzaOrder(String fileName) {
        try {
            String size = fileName.next();
            String crust = fileName.next();
            String eating = fileName.next();
            
            int toppings = 0;
            
            while (fileName.hasNext()) {
                toppings += 1;
            } 

        } catch (Exception e) {
            System.out.println("INVALID ORDER. GOODBYE");
        }
    }
    
       
    public static double pizzaCost(Pizza p) {
        double cost = 0.0; 
        //small pizza
        if (p.getSize() == "small") {
            cost += 4.00;
            if (p.getCrust() == "stuffed") {
                cost += 1.0; // adds 1.0 if stuffed
            }
        } 
        
        // medium pizza
        if (p.getSize() == "medium") {
            cost += 5.50;
            if (p.getCrust() == "stuffed") {
                cost += 2.0; // adds 2.0 if stuffed
            }
        }     
        
        // large pizza
        if (p.getSize() == "large") {
            cost += 7.00;
            if (p.getCrust() == "stuffed") {
                cost += 3.0; // adds 3.0 if stuffed
            }
        }    
        
        //toppings
        if (p.toppingCount() > 0) {
            double toppingCost = 0.75;
            cost += p.toppingCount() * toppingCost;
            if (p.hasTopping("anchovies")) {
                cost += 0.5; // adds 0.5 if it has anchovies
            }
        }
        
        // delivery
        if (p.getDelivery() == true && cost < 10.0) {
            cost += 2.0; // adds 2.0 if it is delivery under $10
        }
        
        return cost; 
    } 

}