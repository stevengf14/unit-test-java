package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class ValidNumberTest {

    private ValidNumber validNumber;

    @BeforeEach
    public void setUp() {
        validNumber = new ValidNumber();
    }

    @AfterEach
    public void tearDown() {
        validNumber = null;
    }

    @Test
    public void checkTest() {
        assertEquals(true, validNumber.check(5));
    }

    @Test
    public void checkNegativeTest() {
        assertEquals(false, validNumber.check(-5));
    }

    @Test
    public void checkStringTest() {
        assertEquals(false, validNumber.check("five"));
    }
    
}
