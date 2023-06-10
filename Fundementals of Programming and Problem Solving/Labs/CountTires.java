// Jacob Igel
// CSE 174, Section D
// Date: 09/10/2021
// Description : Creating a program that will show the number of cars that 
//               will be produced given a set amount of tires. It will also
//               also show the number of tires left over.


public class CountTires {
    public static void main(String[] args) {
    
        // First we will establish all of the variables needed
        final long TIRE_PAIRS = 19873123;
        long totalTires = TIRE_PAIRS * 2;
        long carsProduced = totalTires / 4;
        int tiresLeftOver = (int) totalTires % 4;
        
        // This will output the total number of tires
        System.out.println("The number of: " + totalTires + " tires are added " 
            + "to the production line!");
        
        // This will show the total amount of cars produced
        System.out.println(carsProduced + " cars are produced.");
        
        // This will show the amount of tires left
        System.out.println(tiresLeftOver + " tires are left.");
    
    }
}

