package ec.com.learning.unittest.mockito;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class Login {

    public WebService webService;
    public boolean isLogin;

    public Login(WebService webservice) {
        this.webService = webservice;
        isLogin = false;
    }

    public void doLogin() {
        webService.login("Alberto", "1234", new Callback() {
            @Override
            public void onSuccess(String response) {
                System.out.println(response);
                isLogin = true;
            }

            @Override
            public void onFail(String error) {
                System.out.println(error);
                isLogin = false;
            }

        });
    }
}
