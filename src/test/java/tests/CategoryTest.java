package tests;

import components.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CategoryTest extends BaseTest {

        private String categoryName;
        @Test
        public void createCategory() throws IOException {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss-S");
            categoryName = "Category " + dateFormat.format(date);

            LoginPage loginPage = launchApplication();
            loginPage.typeUsername(getProperties().getProperty("username"));
            loginPage.typePassword(getProperties().getProperty("password"));
            loginPage.clickLoginButton();
            CategoryPage categoryPage = loginPage.goToCategorySection();
            categoryPage.addNewCategory(categoryName);

            Assert.assertTrue(categoryPage.getSearchResults().stream().anyMatch(c->c.equalsIgnoreCase(categoryName)), "Category not found: " + categoryName);
        }
}
