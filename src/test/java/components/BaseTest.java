package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;


    public void initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/global-data-example.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

       if(browserName.equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.manage().window().maximize();
       }
    }
}
