/**
 * Jacob Igel
 * Section: D
 * Sep 2021
 * DicountCalculator.java
 * Discounts purchases based on animal and purchase price.
 */
import java.util.Scanner;  // importing Scanner class

public class DiscountCalculator {
    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        System.out.printf("*Discount Calculator*\n");
        System.out.printf("1. Calculating dog discount\n"
            + "2. Calculating cat discount\n3. Calculating rodent discount\n");
        System.out.printf("Enter a number [1, 2, 3]: ");

        int userNum = in.nextInt();
        
        // Dog Discount
        if (userNum == 1) {
        
            System.out.printf("Enter total purchase: ");
            double dogNum = in.nextDouble();
     
            double dogDiscount;
            double dogPricePay;

            // If the price is less than 100
            if (dogNum <= 100) {
                dogDiscount = dogNum * .10;
                dogPricePay = dogNum - dogDiscount;
                
                System.out.printf("Dog discount (10%%): %.2f", dogDiscount);
                System.out.printf("\nPrice Payable: %.2f", dogPricePay);
                
            // If the price is greater than 100     
            } else if (dogNum >= 100) {
                dogDiscount = dogNum * .20;
                dogPricePay = dogNum - dogDiscount;

                System.out.printf("Dog discount (20%%): %.2f ", dogDiscount); 
                System.out.printf("\nPrice Payable: %.2f", dogPricePay); 
            }
           
                
            
        // Cat Discount
        } else if (userNum == 2) {
            System.out.printf("Enter total purchase: ");
            double catNum = in.nextDouble();
                
            double catDiscount;
            double catPricePay;

            // If the price is less than 100
            if (catNum <= 100) {
                catDiscount = catNum * .10;
                catPricePay = catNum - catDiscount;
                
                System.out.printf("Cat discount (10%%): %.2f", catDiscount);
                System.out.printf("\nPrice Payable: %.2f", catPricePay);
                
            // If the price is greater than 100     
            } else if (catNum >= 100) {
                catDiscount = catNum * .15;
                catPricePay = catNum - catDiscount;

                System.out.printf("Cat discount (15%%): %.2f ", catDiscount); 
                System.out.printf("\nPrice Payable: %.2f", catPricePay); 
            }
           

            // Rodent Discount
        } else if (userNum == 3) {
            System.out.printf("Enter total purchase: ");
            double rodentNum = in.nextDouble();
            
            double rodentDiscount;
            double rodentPricePay;
            
            // If the price is less than 100
            if (rodentNum <= 100) {
                rodentDiscount = rodentNum * .10;
                rodentPricePay = rodentNum - rodentDiscount;
                
                System.out.printf("Rodent discount (10%%): " 
                    + "%.2f", rodentDiscount);
                System.out.printf("\nPrice Payable: %.2f", rodentPricePay);
                
            // If the price is greater than 100
            } else if (rodentNum >= 100) {
                rodentDiscount = rodentNum * .12;
                rodentPricePay = rodentNum - rodentDiscount;
         
                System.out.printf("Rodent discount (12%%): "
                    + "%.2f", rodentDiscount);
                System.out.printf("\nPrice Payable: %.2f", rodentPricePay);
            } 
                           
        } else {
            System.out.printf("Invalid input\n"); 
        }
        System.out.printf("\nEnd\n");
 
    }
}

