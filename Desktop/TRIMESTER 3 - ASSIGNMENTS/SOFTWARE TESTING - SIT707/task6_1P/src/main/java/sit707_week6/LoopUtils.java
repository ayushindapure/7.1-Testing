package sit707_week6;

/**
 * Part B: Two utility functions demonstrating
 * (a) a conditional loop with simple statements
 * (b) a conditional loop containing a conditional statement
 */
public class LoopUtils {

    /**
     * Part B (a): Conditional loop with simple instructions.
     *
     * Calculates the sum of all integers from 1 up to (and including) n.
     * Uses a while loop - the loop condition is the "conditional loop" requirement.
     *
     * @param n upper bound (must be >= 0)
     * @return sum of integers 1..n, or 0 if n <= 0
     */
    public static int sumUpTo(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {       // <-- conditional loop
            sum = sum + i;     // simple instruction in loop body
            i++;
        }
        return sum;
    }

    /**
     * Part B (b): Conditional loop containing a conditional statement.
     *
     * Counts how many numbers from 1 to n are even.
     * Uses a for loop with an if statement inside the loop body.
     *
     * @param n upper bound (must be >= 0)
     * @return count of even numbers in range [1, n]
     */
    public static int countEvens(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {    // <-- conditional loop
            if (i % 2 == 0) {             // <-- conditional statement inside loop
                count++;
            }
        }
        return count;
    }
}