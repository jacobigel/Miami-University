/**
 * @author jacobigel
 */

/**
 * A class to implement several recursive methods for practice. These problems
 * are essentially from codingbat.com
 * 
 * @note There should not be any loops in any of these methods.
 * @note All of these methods are relatively straightforward.
 */
public class RecursionPractice {
    /**
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
     * (n-2) ... 1. Compute the result recursively (without loops) using the
     * recurrence relation that fact(n) = n * fact(n - 1)
     * 
     * @param n The number whose factorial is to be computed.
     * @return The factorial of the number.
     */
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Given a string, compute recursively (no loops) the number of lower case
     * 'x' chars in the string.
     * 
     * @note The String object's charAt(0) and substring(1) methods will come in
     *       handy.
     * 
     * @param str The string in which the number of 'x' characters is counted.
     * @return The number of 'x' characters in the string.
     */
    public int countX(String str) {
        if (str.equals("")) {
            return 0;
        }
        if (str.charAt(0) == 'x') {
            return 1 + countX(str.substring(1));
        } else {
            return countX(str.substring(1));
        }
    }

    /**
     * Given an array of int, compute *recursively* the number of times that the
     * value 11 appears in the array. We'll use the convention of considering
     * only the part of the array that begins at the given index. In this way, a
     * recursive call can pass index+1 to move down the array. The initial call
     * will pass in index as 0.
     * 
     * @param nums  The array in which the number of times the value 11 occurs
     *              is to be computed.
     * 
     * @param index The starting index from where the value is to be computed
     * @return The number of times the value 11 occurs in the array.
     */
    public int array11(final int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (nums[index] == 11) {
            return 1 + array11(nums, index + 1);
        } else {
            return array11(nums, index + 1);
        }
    }

    /**
     * The Fibonacci sequence is a famous bit of mathematics, and it happens to
     * have a recursive definition. The first two values in the sequence are 0
     * and 1 (essentially 2 base cases). Each subsequent value is the sum of the
     * previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
     * 21 and so on. Define a recursive fibonacci(n) method that returns the nth
     * Fibonacci number, with n=0 representing the start of the sequence.
     * 
     * @param n The n'th Fibonacci number to be returned by this method.
     * @return The n'th Fibonacci number.
     */
    public int fibonacci(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * Given a non-negative int n, return the sum of its digits recursively (no
     * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
     * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     * 
     * @param n The number whose digits is to be added.
     * @return The number of the digits of the number.
     */
    public int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + sumDigits(n / 10);
    }

}
