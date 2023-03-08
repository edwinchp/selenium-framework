package tests;

import components.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import resources.utils.TestProperties;

import java.io.IOException;


public class ErrorValidation extends BaseTest {

        @Test
        public void wrongLogin() throws IOException, InterruptedException {
            LoginPage loginPage = launchApplication();
            loginPage.typeUsername("Username");
            loginPage.typePassword(getProperties().getProperty("password"));
            loginPage.clickLoginButton();
            takeScreenshot();
            Assert.assertEquals(loginPage.getErrorMessage(), "Falló al entrar");
        }
}
