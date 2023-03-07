package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private Properties prop;


    protected WebDriver initializeDriver() throws IOException {
        prop = loadProperties();
        String browserName = prop.getProperty("browser");

       if(browserName.equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.manage().window().maximize();
       }

       return driver;
    }

    private Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/main//java//resources//properties//global-data.properties");
        prop.load(fis);
        return prop;
    }

    protected LoginPage launchApplication() throws IOException {
        driver = initializeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo(prop.getProperty("url"));
        return loginPage;
    }

    protected void closeBrowser(){
        driver.quit();
    }
}
