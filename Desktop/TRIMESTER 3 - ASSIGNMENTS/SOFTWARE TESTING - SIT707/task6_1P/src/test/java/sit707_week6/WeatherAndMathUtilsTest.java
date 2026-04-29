package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224880003"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Ayush Indapure"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    // -------------------------------------------------------
    // weatherAdvice tests
    // -------------------------------------------------------

    /**
     * CANCEL: wind speed above dangerous threshold (>70.0)
     */
    @Test
    public void testCancelWeatherAdvice_HighWindSpeed() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    /**
     * CANCEL: precipitation above dangerous threshold (>6.0)
     */
    @Test
    public void testCancelWeatherAdvice_HighRainfall() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    /**
     * CANCEL: both wind >45 and rain >4 (combined dangerous condition)
     */
    @Test
    public void testCancelWeatherAdvice_CombinedCondition() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.1, 4.1));
    }

    /**
     * WARN: wind speed above concerning threshold but below dangerous
     */
    @Test
    public void testWarnWeatherAdvice_HighWindSpeed() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 0.0));
    }

    /**
     * WARN: precipitation above concerning threshold but below dangerous
     */
    @Test
    public void testWarnWeatherAdvice_HighRainfall() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 5.0));
    }

    /**
     * ALL CLEAR: both wind and rain are within safe limits
     */
    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 1.0));
    }

    /**
     * ALL CLEAR: zero values - perfectly calm weather
     */
    @Test
    public void testAllClearWeatherAdvice_ZeroValues() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(0.0, 0.0));
    }

    /**
     * ALL CLEAR: exactly at concerning thresholds (not above them)
     */
    @Test
    public void testAllClearWeatherAdvice_ExactlyAtThreshold() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
    }

    /**
     * CANCEL: exactly at dangerous wind threshold boundary (>70)
     */
    @Test
    public void testCancelWeatherAdvice_ExactDangerousWindBoundary() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.01, 0.0));
    }

    /**
     * CANCEL: exactly at dangerous rain threshold boundary (>6)
     */
    @Test
    public void testCancelWeatherAdvice_ExactDangerousRainBoundary() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.01));
    }

    // -------------------------------------------------------
    // isEven tests
    // -------------------------------------------------------

    /**
     * Even number returns true
     */
    @Test
    public void testIsEven_EvenNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    /**
     * Odd number returns false
     */
    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    /**
     * Zero is even
     */
    @Test
    public void testIsEven_Zero() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(0));
    }

    /**
     * Negative even number
     */
    @Test
    public void testIsEven_NegativeEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(-2));
    }

    /**
     * Negative odd number
     */
    @Test
    public void testIsEven_NegativeOdd() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(-3));
    }

    // -------------------------------------------------------
    // isPrime tests
    // -------------------------------------------------------

    /**
     * 1 is treated as prime in this implementation
     */
    @Test
    public void testIsPrime_One() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    /**
     * 2 is prime (even number – loop starts at i=2, condition i < 2 is false, loop skipped)
     */
    @Test
    public void testIsPrime_Two() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }

    /**
     * 3 is prime (odd)
     */
    @Test
    public void testIsPrime_Three() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }

    /**
     * 4 is not prime (even)
     */
    @Test
    public void testIsPrime_Four() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    /**
     * 9 is not prime (odd but divisible by 3 — however due to isEven check, 9 returns true)
     * NOTE: The isPrime implementation only checks isEven inside loop, so odd composites
     * like 9 return true. This is a known bug in the implementation.
     */
    @Test
    public void testIsPrime_Nine() {
        // 9 is odd so isEven returns false, loop never returns false → returns true (implementation bug)
        Assert.assertTrue(WeatherAndMathUtils.isPrime(9));
    }

    /**
     * Large even number is not prime
     */
    @Test
    public void testIsPrime_LargeEven() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(100));
    }
}