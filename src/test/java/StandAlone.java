import components.BaseTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import resources.utils.TestProperties;

import java.io.IOException;


public class StandAlone extends BaseTest {

        @Test
        public void login() throws IOException {
            LoginPage loginPage = launchApplication();
            TestProperties testProperties = new TestProperties();
            loginPage.typeUsername(testProperties.getProperties().getProperty("username"));
            loginPage.typePassword(testProperties.getProperties().getProperty("password"));
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.isNavbarDisplayed());

            closeBrowser();
        }
}
