package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class AddCreateMock1Test {

    private Add add;
    private ValidNumber validNumber;

    @BeforeEach
    public void setUp() {
        validNumber = Mockito.mock(ValidNumber.class);
        add = new Add(validNumber);
    }

    @Test
    public void addTest() {
        add.add(3, 2);
        Mockito.verify(validNumber).check(3);
        //Mockito.verify(validNumber).check(5);
    }

}
