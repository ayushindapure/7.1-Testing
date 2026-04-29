package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // ── Q1 Addition ──────────────────────────────────────────

    @Test
    public void testQ1AdditionCorrect() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testQ1AdditionWithDecimals() {
        Assert.assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3.0"), 0);
    }

    @Test
    public void testQ1AdditionWithZero() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("5", "0"), 0);
    }

    @Test
    public void testQ1AdditionNegativeNumbers() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("-3", "2"), 0);
    }

    @Test
    public void testQ1AdditionNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testQ1AdditionNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("5", ""));
    }

    @Test
    public void testQ1AdditionBothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testQ1AdditionNumber1Null() {
        Assert.assertNull(MathQuestionService.q1Addition(null, "2"));
    }

    @Test
    public void testQ1AdditionNumber2Null() {
        Assert.assertNull(MathQuestionService.q1Addition("5", null));
    }

    @Test
    public void testQ1AdditionNonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }

    // ── Q2 Subtraction ───────────────────────────────────────

    @Test
    public void testQ2SubtractionCorrect() {
        Assert.assertEquals(3.0, MathQuestionService.q2Subtraction("5", "2"), 0);
    }

    @Test
    public void testQ2SubtractionResultZero() {
        Assert.assertEquals(0.0, MathQuestionService.q2Subtraction("4", "4"), 0);
    }

    @Test
    public void testQ2SubtractionNegativeResult() {
        Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0);
    }

    @Test
    public void testQ2SubtractionWithDecimals() {
        Assert.assertEquals(1.5, MathQuestionService.q2Subtraction("4.5", "3.0"), 0);
    }

    @Test
    public void testQ2SubtractionNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testQ2SubtractionNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", ""));
    }

    @Test
    public void testQ2SubtractionBothNull() {
        Assert.assertNull(MathQuestionService.q2Subtraction(null, null));
    }

    @Test
    public void testQ2SubtractionNonNumericInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", "xyz"));
    }

    // ── Q3 Multiplication ────────────────────────────────────

    @Test
    public void testQ3MultiplicationCorrect() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
    }

    @Test
    public void testQ3MultiplicationByZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("5", "0"), 0);
    }

    @Test
    public void testQ3MultiplicationNegative() {
        Assert.assertEquals(-6.0, MathQuestionService.q3Multiplication("-2", "3"), 0);
    }

    @Test
    public void testQ3MultiplicationDecimals() {
        Assert.assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3"), 0);
    }

    @Test
    public void testQ3MultiplicationNumber1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "3"));
    }

    @Test
    public void testQ3MultiplicationNumber2Null() {
        Assert.assertNull(MathQuestionService.q3Multiplication("3", null));
    }

    @Test
    public void testQ3MultiplicationNonNumeric() {
        Assert.assertNull(MathQuestionService.q3Multiplication("abc", "3"));
    }
}