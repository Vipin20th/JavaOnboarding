package TestNGHomeTask;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    // Positive tests
    @Test(groups = {"positive"})
    public void testAdditionPositive() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test(groups = {"positive"})
    public void testSubtractionPositive() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test(groups = {"positive"})
    public void testMultiplicationPositive() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test(groups = {"positive"})
    public void testDivisionPositive() {
        assertEquals(3, calculator.divide(15, 5));
    }

    @Test(groups = {"positive"})
    public void testSquareRootPositive() {
        assertEquals(3, calculator.squareRoot(9));
    }

    // Negative tests
    @Test(groups = {"negative"})
    public void testDivisionByZeroNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test(groups = {"negative"})
    public void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-9));
    }

    @Test(groups = {"negative"})
    public void testInvalidOperationNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.performOperation(5, 3, "unknown"));
    }

    @Test(groups = {"negative"})
    public void testAdditionOverflowNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
    }

    @Test(groups = {"negative"})
    public void testSubtractionOverflowNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][] {
                {10, 2, 5},
                {15, 3, 5},
                {20, 4, 5}
        };
    }

    @Test(dataProvider = "divisionData")
    public void testDivisionParameterized(int dividend, int divisor, int expected) {
        assertEquals(expected, calculator.divide(dividend, divisor));
    }
}

