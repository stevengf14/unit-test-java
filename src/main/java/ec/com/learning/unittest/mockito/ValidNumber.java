package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class ValidNumber {

    public boolean check(Object o) {
        if (o instanceof Integer) {
            if ((Integer) o < 10 && (Integer) o >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
