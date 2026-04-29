package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

/**
 * Part B tests for LoopUtils.
 * These tests target >90% code coverage for both
 * (a) sumUpTo  - conditional loop with simple statements
 * (b) countEvens - conditional loop with conditional statement inside
 */
public class LoopUtilsTest {

    // -------------------------------------------------------
    // sumUpTo tests  (Part B - a)
    // -------------------------------------------------------

    /**
     * n = 0: loop body never executes → sum = 0
     * This covers the FALSE branch of the while condition (loop skipped entirely)
     */
    @Test
    public void testSumUpTo_Zero() {
        Assert.assertEquals(0, LoopUtils.sumUpTo(0));
    }

    /**
     * n = 1: loop executes once → sum = 1
     */
    @Test
    public void testSumUpTo_One() {
        Assert.assertEquals(1, LoopUtils.sumUpTo(1));
    }

    /**
     * n = 5: loop executes 5 times → sum = 1+2+3+4+5 = 15
     * This covers the TRUE branch of the while condition (loop body executed)
     */
    @Test
    public void testSumUpTo_Five() {
        Assert.assertEquals(15, LoopUtils.sumUpTo(5));
    }

    /**
     * n = 10: sum = 55
     */
    @Test
    public void testSumUpTo_Ten() {
        Assert.assertEquals(55, LoopUtils.sumUpTo(10));
    }

    /**
     * Negative n: loop never executes → sum = 0
     */
    @Test
    public void testSumUpTo_Negative() {
        Assert.assertEquals(0, LoopUtils.sumUpTo(-5));
    }

    // -------------------------------------------------------
    // countEvens tests  (Part B - b)
    // -------------------------------------------------------

    /**
     * n = 0: loop never executes → count = 0
     * Covers FALSE branch of for-loop condition
     */
    @Test
    public void testCountEvens_Zero() {
        Assert.assertEquals(0, LoopUtils.countEvens(0));
    }

    /**
     * n = 1: only 1 in range, which is odd → count = 0
     * Covers loop body executing but if-condition being FALSE
     */
    @Test
    public void testCountEvens_One() {
        Assert.assertEquals(0, LoopUtils.countEvens(1));
    }

    /**
     * n = 2: range is [1,2], one even number → count = 1
     * Covers loop body executing with if-condition TRUE (i=2 is even)
     */
    @Test
    public void testCountEvens_Two() {
        Assert.assertEquals(1, LoopUtils.countEvens(2));
    }

    /**
     * n = 6: evens are 2,4,6 → count = 3
     */
    @Test
    public void testCountEvens_Six() {
        Assert.assertEquals(3, LoopUtils.countEvens(6));
    }

    /**
     * n = 10: evens are 2,4,6,8,10 → count = 5
     */
    @Test
    public void testCountEvens_Ten() {
        Assert.assertEquals(5, LoopUtils.countEvens(10));
    }

    /**
     * Negative n: loop never executes → count = 0
     */
    @Test
    public void testCountEvens_Negative() {
        Assert.assertEquals(0, LoopUtils.countEvens(-3));
    }
}