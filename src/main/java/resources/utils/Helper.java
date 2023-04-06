package resources.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

public class Helper {
    private static Helper Helper;
    private static WebDriver driver;
    private static Properties prop;


    private Helper(){
        initProps();
        initDriver();
    }

    private static void initDriver(){
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    private static void initProps(){
        prop = new Properties();
        prop = new TestProperties().getProperties();
    }

    public static void setUpDriver(){
        if(Helper == null){
            Helper = new Helper();
        }
    }

    public static void tearDownDriver() {
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        Helper = null;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static String getTestData(String propertyName){
        return prop.getProperty(propertyName);
    }

}
