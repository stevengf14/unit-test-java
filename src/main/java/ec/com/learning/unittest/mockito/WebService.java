package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class WebService {

    public boolean checkLogin(String user, String password) {
        return user.equals("Alberto") && password.equals("1234");
    }
}
