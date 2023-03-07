package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import resources.utils.TestProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private TestProperties prop;


    protected WebDriver initializeDriver() throws IOException {
        prop = new TestProperties();

       if(prop.getProperties().getProperty("browser").equalsIgnoreCase("chrome")){
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
        loginPage.goTo(prop.getProperties().getProperty("url"));
        return loginPage;
    }

    protected void closeBrowser(){
        driver.quit();
    }
}
