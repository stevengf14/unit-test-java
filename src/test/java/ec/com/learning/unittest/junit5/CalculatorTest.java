package ec.com.learning.unittest.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @Test
    public void calculatorNotNullTest() {
        //assertNull(calculator);
        System.out.println("@Test -> calculatorNotNullTest()");
        assertNotNull(calculator, "Calculator must be not null");
    }

}
