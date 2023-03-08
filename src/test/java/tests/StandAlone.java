package tests;

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
            loginPage.typeUsername(getProperties().getProperty("username"));
            loginPage.typePassword(getProperties().getProperty("password"));
            takeScreenshot();
            loginPage.clickLoginButton();
            takeScreenshot();
            Assert.assertTrue(loginPage.isNavbarDisplayed());
        }
}
