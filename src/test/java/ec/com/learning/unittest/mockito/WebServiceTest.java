package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class WebServiceTest {

    private WebService webService;

    @BeforeEach
    public void setUp() {
        webService = new WebService();
    }

    @Test
    public void checkLoginTest() {
        assertTrue(webService.checkLogin("Alberto", "1234"));
    }

    @Test
    public void checkLoginErrorTest() {
        assertFalse(webService.checkLogin("Error", "12345"));
    }

}
