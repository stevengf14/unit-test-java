package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public interface Callback {

    void onSuccess(String response);

    void onFail(String error);

}
