package ec.com.learning.unittest.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void calculatorNotNullTest() {
        //assertNull(calculator);
        calculator = new Calculator();
        assertNotNull(calculator, "Calculator must be not null");
    }

}
