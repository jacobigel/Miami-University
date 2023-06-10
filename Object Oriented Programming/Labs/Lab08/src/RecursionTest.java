import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is a simple JUnit test class for RecursionPractice problems.
 * The unit tests are pretty much the same that are run by codingbat.com
 *
 */
public class RecursionTest extends RecursionPractice {

    @Test
    public void testFactorial() {
        // factorial(1) -> 1
        assertEquals(factorial(1), 1);
        // factorial(2) -> 2
        assertEquals(factorial(2), 2);
        // factorial(3) -> 6
        assertEquals(factorial(3), 6);
        // factorial(4) -> 24
        assertEquals(factorial(4), 24);
        // factorial(5) -> 120
        assertEquals(factorial(5), 120);
        // factorial(6) -> 720
        assertEquals(factorial(6), 720);
        // factorial(7) -> 5040
        assertEquals(factorial(7), 5040);
        // factorial(12) -> 479001600
        assertEquals(factorial(12), 479001600);
    }

    @Test
    public void testCountX() {
        // countX("xxhixx") -> 4
        assertEquals(countX("xxhixx"), 4);
        // countX("xhixhix") -> 3
        assertEquals(countX("xhixhix"), 3);
        // countX("hi") -> 0
        assertEquals(countX("hi"), 0);
        // countX("h") -> 0
        assertEquals(countX("h"), 0);
        // countX("x") -> 1
        assertEquals(countX("x"), 1);
        // countX("") -> 0
        assertEquals(countX(""), 0);
        // countX("hihi") -> 0
        assertEquals(countX("hihi"), 0);
        // countX("hiAAhi12hi") -> 0
        assertEquals(countX("hiAAhi12hi"), 0);
    }

    @Test
    public void testArray11() {
        // array11([1, 2, 11], 0) -> 1
        assertEquals(array11(new int[] {1, 2, 11}, 0), 1);
        // array11([11, 11], 0) -> 2
        assertEquals(array11(new int[] {11, 11}, 0), 2);
        // array11([1, 2, 3, 4], 0) -> 0
        assertEquals(array11(new int[] {1, 2, 3, 4}, 0), 0);
        // array11([1, 11, 3, 11, 11], 0) -> 3
        assertEquals(array11(new int[] {1, 11, 3, 11, 11}, 0), 3);
        // array11([11], 0) -> 1
        assertEquals(array11(new int[] {11}, 0), 1);
        // array11([1], 0) -> 0
        assertEquals(array11(new int[] {1}, 0), 0);
        // array11([], 0) -> 0
        assertEquals(array11(new int[] {}, 0), 0);
        // array11([11, 2, 3, 4, 11, 5], 0) -> 2
        assertEquals(array11(new int[] {11, 2, 3, 4, 11, 5}, 1), 1);
        // array11([11, 5, 11], 0) -> 2
        assertEquals(array11(new int[] {11, 5, 11}, 0), 2);
    }

    @Test
    public void testFibonacci() {
        // fibonacci(0) -> 0
        assertEquals(fibonacci(0), 0);
        // fibonacci(1) -> 1
        assertEquals(fibonacci(1), 1);
        // fibonacci(2) -> 1
        assertEquals(fibonacci(2), 1);
        // fibonacci(3) -> 2
        assertEquals(fibonacci(3), 2);
        // fibonacci(4) -> 3
        assertEquals(fibonacci(4), 3);
        // fibonacci(5) -> 5
        assertEquals(fibonacci(5), 5);
        // fibonacci(6) -> 8
        assertEquals(fibonacci(6), 8);
        // fibonacci(7) -> 13
        assertEquals(fibonacci(7), 13);
    }

    @Test
    public void testSumDigits() {
        // sumDigits(126) -> 9
        assertEquals(sumDigits(126), 9);
        // sumDigits(49) -> 13
        assertEquals(sumDigits(49), 13);
        // sumDigits(12) -> 3
        assertEquals(sumDigits(12), 3);
        // sumDigits(10) -> 1
        assertEquals(sumDigits(10), 1);
        // sumDigits(1) -> 1
        assertEquals(sumDigits(1), 1);
        // sumDigits(0) -> 0
        assertEquals(sumDigits(0), 0);
        // sumDigits(730) -> 10
        assertEquals(sumDigits(730), 10);
        // sumDigits(1111) -> 4
        assertEquals(sumDigits(1111), 4);
        // sumDigits(11111) -> 5
        assertEquals(sumDigits(11111), 5);
        // sumDigits(10110) -> 3
        assertEquals(sumDigits(10110), 3);
        // sumDigits(235) -> 10
        assertEquals(sumDigits(235), 10);
    }
}
