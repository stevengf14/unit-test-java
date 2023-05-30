package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class WebServiceTest {

    private WebService webService;
    @Mock
    private Callback callback;

    @BeforeEach
    public void setUp() {
        webService = new WebService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkLoginTest() {
        assertTrue(webService.checkLogin("Alberto", "1234"));
    }

    @Test
    public void checkLoginErrorTest() {
        assertFalse(webService.checkLogin("Error", "12345"));
    }

    @Test
    public void loginTest() {
        webService.login("Alberto", "1234", callback);
        verify(callback).onSuccess("User is correct");
    }

    @Test
    public void loginErrorTest() {
        webService.login("Error", "12345", callback);
        verify(callback).onFail("Error");
    }

}
