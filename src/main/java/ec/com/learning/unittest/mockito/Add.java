package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class Add {

    private ValidNumber validNumber;

    public Add(ValidNumber validNumber) {
        this.validNumber = validNumber;
    }

    public int add(Object a, Object b) {
        if (validNumber.check(a) && validNumber.check(b)) {
            return (Integer) a + (Integer) b;
        }
        return 0;
    }
    
}
