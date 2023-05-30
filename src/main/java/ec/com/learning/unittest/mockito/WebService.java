package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class WebService {

    public void login(String user, String password, Callback callback) {
        if (checkLogin(user, password)) {
            callback.onSuccess("User is correct");
        } else {
            callback.onFail("Error");
        }
    }

    public boolean checkLogin(String user, String password) {
        return user.equals("Alberto") && password.equals("1234");
    }
}
