import components.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;


public class StandAlone extends BaseTest {

        @Test
        public void login() throws IOException {
            LoginPage loginPage = launchApplication();
            loginPage.typeUsername("Secretario Edwin");
            loginPage.typePassword("vivacristorey");
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.isNavbarDisplayed());

            closeBrowser();
        }
}
