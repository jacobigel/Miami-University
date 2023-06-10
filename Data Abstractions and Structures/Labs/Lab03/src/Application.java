
/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals.    

/**
 * @author jacobigel
 */

import java.io.*;

class Stack<unknown> {

    private int maxSize;

    private unknown[] StackArray;

    private int top;

    public Stack(int s) {
        maxSize = s;
        top = -1;

        StackArray = (unknown[]) new Object[maxSize];
    }

    public void push(unknown j)

    {

        top = top + 1;
        StackArray[top] = j;

    }

    public unknown pop()

    {

        unknown temp = StackArray[top];
        top = top - 1;
        return temp;

    }

    public boolean isEmpty()

    {

        return (top == -1);

    }

}

class StackC

{

    private int maxSize;

    private char[] stackArray;

    private int top;

    public StackC(int s)

    {

        maxSize = s;

        stackArray = new char[maxSize];

        top = -1;

    }

    public void push(char j)

    {

        top = top + 1;
        stackArray[top] = j;

    }

    public char pop()

    {

        char temp = stackArray[top];
        top = top - 1;
        return temp;

    }

    public boolean isEmpty()

    {

        return (top == -1);

    }

}

class ExpressionChecker

{

    private String input;

    public ExpressionChecker(String in)

    {
        input = in;
    }

    public boolean check()

    {

        int stackSize = input.length();

//        StackC theStack = new StackC(stackSize);

        Stack<Character> theStack = new Stack<Character>(stackSize);

//        StackC theStack = new StackC(stackSize);

        for (int j = 0; j < input.length(); j++)

        {

            char ch = input.charAt(j);

            if (ch == '{')
                theStack.push(ch);

            if (ch == '[')
                theStack.push(ch);

            if (ch == '(')
                theStack.push(ch);

            if (ch == '}') {
                if (theStack.isEmpty())
                    return false;
                if (theStack.pop() != '{')
                    return false;
            }

            if (ch == ']') {
                if (theStack.isEmpty())
                    return false;
                if (theStack.pop() != '[')
                    return false;
            }

            if (ch == ')') {
                if (theStack.isEmpty())
                    return false;

                if (theStack.pop() != '(')
                    return false;
            }

        }

        if (!theStack.isEmpty()) {
            return false;
        }

        return true;

    }

}

class Application

{

    public static void main(String[] args) throws IOException

    {
//      Question 1
//        String input;
//        input="{7-(348+[1*9]+15)-3}";
////        (93{82}738) - Balanced
////        {93[8{}2]738} - Balanced
////        {[4{44(85)31}22]75}(14) - Balanced
////        {( {(29[3]) ([351]1{9[2]7)})} - Unbalanced
//        ExpressionChecker theChecker = new ExpressionChecker(input);
//        System.out.println(theChecker.check());

//      Question 2
//        InputStreamReader isr = new InputStreamReader(System.in);
//
//        String input;
//        
//
//        do {
//            input = getString();
//            ExpressionChecker theChecker2 = new ExpressionChecker(input);
//            System.out.println(theChecker2.check());
//
//        } while (input != null);

//      Question 3
//        String input= "(38[72{53}])";
//        ExpressionChecker theChecker = new ExpressionChecker(input);
//        System.out.println(theChecker.check());
        
//      Question 4
//        String input = "{(38[72{53}])";
//        ExpressionChecker theChecker = new ExpressionChecker(input);
//        System.out.println(theChecker.check());

    }

    public static String getString() throws IOException

    {

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();

        return s;

    }

}
