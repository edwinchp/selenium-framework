package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.utils.TestProperties;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static WebDriver driver;
    private static Properties prop;

    public static WebDriver getDriver(){
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
