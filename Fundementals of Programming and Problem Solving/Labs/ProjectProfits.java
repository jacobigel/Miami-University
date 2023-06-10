3.0*// Jacob Igel
// CSE 174, Section D
// Date: 09/03/2021
// Description : Creating a program that will calculate average profit for
//               certain years. This program will also calculate the total
//               average profits for 3 years together.

public class ProjectProfits {
    public static void main(String[] args) {
        // Create constant variables to hold predicted imcomes.
        final int PREDICT_INCOME1 = 2000000;
        final int PREDICT_INCOME2 = 2500000;
        final int PREDICT_INCOME3 = 3000000;
        final int PREDICT_INCOME4 = 4000000;
        
        // Store the profit percentages per each year.
        float nextYear1 = 0.051f;
        float nextYear2 = 0.072f;
        float nextYear3 = 0.093f;
        float nextYear4 = 0.112f;
        
        // This will give us the predicted income * the profit percentages for
        // each year.
        float totalNextYear1 = PREDICT_INCOME1 * nextYear1;
        float totalNextYear2 = PREDICT_INCOME2 * nextYear2;
        float totalNextYear3 = PREDICT_INCOME3 * nextYear3;
        float totalNextYear4 = PREDICT_INCOME4 * nextYear4;
        
        // This will give us the average for all predicted incomes
        // added together (next year).
        float averageProfit1 = (totalNextYear1 + totalNextYear2
             + totalNextYear3 + totalNextYear4) / 4;
        System.out.println("The average profit for the next year: "
             + averageProfit1);
             
        float secondYear1 = 0.060f;
        float secondYear2 = 0.080f;
        float secondYear3 = 0.101f;
        float secondYear4 = 0.132f;
        
        float totalSecondYear1 = PREDICT_INCOME1 * secondYear1;
        float totalSecondYear2 = PREDICT_INCOME2 * secondYear2;
        float totalSecondYear3 = PREDICT_INCOME3 * secondYear3;
        float totalSecondYear4 = PREDICT_INCOME4 * secondYear4;
        
        // This will give us the average for all predicted incomes
        // added together (second year).
        float averageProfit2 = (totalSecondYear1 + totalSecondYear2
             + totalSecondYear3 + totalSecondYear4) / 4;
        System.out.println("The average profit for the second year: "
             + averageProfit2);
            
        float thirdYear1 = 0.080f;
        float thirdYear2 = 0.105f;
        float thirdYear3 = 0.130f;
        float thirdYear4 = 0.168f;
        
        float totalThirdYear1 = PREDICT_INCOME1 * thirdYear1;
        float totalThirdYear2 = PREDICT_INCOME2 * thirdYear2;
        float totalThirdYear3 = PREDICT_INCOME3 * thirdYear3;
        float totalThirdYear4 = PREDICT_INCOME4 * thirdYear4;
        
        // This will give us the average for all predicted incomes
        // added together (third year).
        float averageProfit3 = (totalThirdYear1 + totalThirdYear2
             + totalThirdYear3 + totalThirdYear4) / 4;
        System.out.println("The average profit for the third year: "
             + averageProfit3);
        
        // This will add all of the average profits together and display
        // them showing the total three year average profit.
        float totalProfit = averageProfit1 + averageProfit2 + averageProfit3;
        System.out.println("\nTotal profit in next 3 years: " 
            + (int) totalProfit);
                 
    }
}
   