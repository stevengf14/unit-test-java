package ec.com.learning.unittest.junit5;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

        assertEquals("string", "string");
        // assertEquals("string", "sring", "Test failed");

        assertEquals(1, 1.4, 0.5);
        assertEquals(1, 0.7, 0.5);

        System.out.println("@Test -> assertTypesTest()");
    }

    @Test
    public void add_ValidInputExpected_Test() {
        assertEquals(11, calculator.add(7, 4));
        System.out.println("@Test -> add_ValidInputExpected_Test()");
    }

    @Test
    public void substract_ValidInputExpected_Test() {
        assertEquals(11, calculator.subtract(15, 4));
        System.out.println("@Test -> substract_ValidInputExpected_Test()");
    }

    @Test
    public void substract_ValidInput_ValidNegativeResultExpected_Test() {
        assertEquals(-11, calculator.subtract(-15, -4));
        System.out.println("@Test -> substract_ValidInput_ValidNegativeResultExpected_Test()");
    }

    @Test
    public void divide_ValidInput_ValidResultExpected_Test() {
        assertEquals(2, calculator.divide(10, 5));
        System.out.println("@Test -> divide_ValidInput_ValidResultExpected_Test()");
    }

    /*@Test
    public void divide_InValidInput_Test() {
        fail("Failed detected - No divide by zero");
        calculator.divide(10, 0);
        System.out.println("@Test -> divide_InValidInput_Test()");
    }*/
    @Test
    public void divide_InValidInput_ExpectedException_Test() {
        assertThrows(ArithmeticException.class, () -> calculator.divideByZero(10, 0), "No divide by zero");
        System.out.println("@Test -> divide_InValidInput_ExpectedException_Test()");
    }

    @Disabled("Disabled until bug 23 be resolved")
    @Test
    public void divide_InvalidInput_Test() {
        assertEquals(2, calculator.divide(5, 0));
        System.out.println("@Test -> divide_InvalidInput_Test()");
    }

    @Test
    @DisplayName("Divide Method -> It works!")
    public void divide_ValidInput_ValidResultExpected_Name_Test() {
        assertEquals(2, calculator.divide(10, 5));
        System.out.println("@Test -> divide_ValidInput_ValidResultExpected_Name_Test()");
    }

    @Test
    public void add_Assert_All_Test() {
        assertAll(
                () -> assertEquals(30, calculator.add(10, 20)),
                () -> assertEquals(20, calculator.add(10, 10)),
                () -> assertEquals(2, calculator.add(1, 1))
        );
        System.out.println("@Test -> add_Assert_All_Test()");
    }

    @Nested
    class AddTest {

        @Test
        public void add_Positive_Test() {
            assertEquals(30, calculator.add(15, 15));
            System.out.println("@Test -> add_Positive_Test()");
        }

        @Test
        public void add_Negative_Test() {
            assertEquals(-30, calculator.add(-15, -15));
            System.out.println("@Test -> add_Negative_Test()");
        }

        @Test
        public void add_Zero_Test() {
            assertEquals(0, calculator.add(0, 0));
            System.out.println("@Test -> add_Zero_Test()");
        }

    }

}
