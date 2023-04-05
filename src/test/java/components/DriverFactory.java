package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.utils.TestProperties;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private WebDriver driver;
    private Properties prop;

    public DriverFactory(){
        //this.driver = driver;
    }

    public WebDriver getDriver(){
        prop = new Properties();
        prop = new TestProperties().getProperties();

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
