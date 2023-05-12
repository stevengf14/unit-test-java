package ec.com.learning.unittest.junit5;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void calculatorNotNullTest() {
        //assertNull(calculator);
        assertNotNull(calculator, "Calculator must be not null");
        System.out.println("@Test -> calculatorNotNullTest()");
    }

    @Test
    public void calculatorNullTest() {
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");
    }

    @Test
    public void addAssertTest() {
        // 1. SetUp
        int expectedResult = 30;
        int currentResult;

        // 2. Action
        currentResult = calculator.add(10, 20);

        // 3. Assert
        assertEquals(expectedResult, currentResult);

        System.out.println("@Test -> addAssertTest()");
    }

    @Test
    public void addTest() {
        assertEquals(30, calculator.add(10, 20));
        System.out.println("@Test -> addTest()");
    }

    @Test
    public void assertTypesTest() {
        assertTrue(1 == 1);
        // assertTrue(1 == 2);

        assertNull(calculatorNull);
        assertNotNull(calculator);

        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        Calculator calculator3 = calculator1;

        assertSame(calculator1, calculator3);
        //assertSame(calculator1, calculator2);

        assertNotSame(calculator1, calculator2);

        System.out.println("@Test -> assertTypesTest()");
    }

}
