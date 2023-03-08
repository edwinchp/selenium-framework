package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.LoginPage;
import resources.utils.TestProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private Properties prop;


    protected WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        prop = new TestProperties().getProperties();

       if(getProperties().getProperty("browser").equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.manage().window().maximize();
       }

       return driver;
    }

    protected LoginPage launchApplication() throws IOException {
        driver = initializeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo(getProperties().getProperty("url"));
        return loginPage;
    }

    protected Properties getProperties(){
        return prop;
    }

    @AfterMethod
    protected void closeBrowser(){
        driver.close();
    }
}
