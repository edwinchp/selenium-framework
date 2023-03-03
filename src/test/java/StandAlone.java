import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class StandAlone {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http:localhost:8000");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Secretario Edwin");
        loginPage.typePassword("vivacristorey");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isNavbarDisplayed());

        driver.quit();
    }
}
