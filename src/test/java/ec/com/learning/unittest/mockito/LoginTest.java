package ec.com.learning.unittest.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class LoginTest {

    @InjectMocks
    private Login login;

    @Mock
    private WebService webService;

    @Captor
    private ArgumentCaptor<Callback> callbackArgumentCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doLoginTest() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String) invocationOnMock.getArguments()[0];
                assertEquals("Alberto", user);
                String password = (String) invocationOnMock.getArguments()[1];
                assertEquals("1234", password);
                Callback callback = (Callback) invocationOnMock.getArguments()[2];
                callback.onSuccess("User is correct");
                return null;

            }
        }).when(webService).login(anyString(), anyString(), any(Callback.class));
        login.doLogin();
        verify(webService, times(1)).login(anyString(), anyString(), any(Callback.class));
        assertEquals(login.isLogin, true);
    }

    public void doLoginErrorTest() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String user = (String) invocationOnMock.getArguments()[0];
                assertEquals("Error", user);
                String password = (String) invocationOnMock.getArguments()[1];
                assertEquals("12345", password);
                Callback callback = (Callback) invocationOnMock.getArguments()[2];
                callback.onFail("Error");
                return null;

            }
        }).when(webService).login(anyString(), anyString(), any(Callback.class));
        login.doLogin();
        verify(webService, times(1)).login(anyString(), anyString(), any(Callback.class));
        assertEquals(login.isLogin, true);
    }

    @Test
    public void doLoginCaptorTest() {
        login.doLogin();
        verify(webService, times(1)).login(anyString(), anyString(), callbackArgumentCaptor.capture());
        assertEquals(login.isLogin, false);

        Callback callback = callbackArgumentCaptor.getValue();
        callback.onSuccess("User is correct");
        assertEquals(login.isLogin, true);

        callback.onFail("Error");
        assertEquals(login.isLogin, false);
    }
}
