package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author steve
 */
public class AddTest {

    @InjectMocks
    private Add add;
    @Mock
    private ValidNumber validNumber;
    @Mock
    private Print print;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addTest() {
        when(validNumber.check(3)).thenReturn(true);
        boolean checkNumber = validNumber.check(3);
        assertEquals(true, checkNumber);

        when(validNumber.check("a")).thenReturn(false);
        checkNumber = validNumber.check("a");
        assertEquals(false, checkNumber);
    }

    @Test
    public void addMockExceptionTest() {
        when(validNumber.checkZero(0)).thenThrow(new ArithmeticException("We can't accept zero"));
        Exception exception = null;
        try {
            validNumber.checkZero(0);
        } catch (ArithmeticException e) {
            exception = e;
        }
        assertNotNull(exception);
    }

    @Test
    public void addRealMethodTest() {
        when(validNumber.checkZero(3)).thenCallRealMethod();
        assertEquals(true, validNumber.checkZero(3));

        when(validNumber.checkZero("3")).thenCallRealMethod();
        assertEquals(false, validNumber.checkZero("3"));
    }

    @Test
    public void addDoubleToIntThenAnswerTest() {
        Answer<Integer> answer = new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return 7;
            }
        };
        when(validNumber.doubleToInt(7.7)).thenAnswer(answer);
        assertEquals(14, add.addInt(7.7));
    }

    // Arrange
    // Act 
    // Assert
    @Test
    public void patternTest() {
        // Arrange
        when(validNumber.check(4)).thenReturn(true);
        when(validNumber.check(5)).thenReturn(true);
        // Act
        int result = add.add(4, 5);
        // Assert
        assertEquals(9, result);
    }

    // Given
    // When
    // Then
    @Test
    public void patternBDDTest() {
        // Given
        given(validNumber.check(4)).willReturn(true);
        given(validNumber.check(5)).willReturn(true);
        // When
        int result = add.add(4, 5);
        // Then
        assertEquals(9, result);
    }

    @Test
    public void argumentMatcherTest() {
        // Given
        given(validNumber.check(anyInt())).willReturn(true);
        given(validNumber.check(anyInt())).willReturn(true);
        // When
        int result = add.add(4, 5);
        // Then
        assertEquals(9, result);
    }

    @Test
    public void addPrintTest() {
        // Given
        given(validNumber.check(4)).willReturn(true);
        given(validNumber.check(5)).willReturn(true);
        // When
        add.addPrint(4, 5);
        // Then
        verify(validNumber).check(4);
        // verify(validNumber, Mockito.times(2)).check(4);
        verify(validNumber, Mockito.never()).check(99);
        verify(validNumber, Mockito.atLeast(1)).check(4);
        verify(validNumber, Mockito.atMost(3)).check(4);
        verify(validNumber, Mockito.atLeastOnce()).check(4);

        verify(print).showMessage(9);
        verify(print, Mockito.never()).showError();
    }

}
