package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.LoginPage;
import resources.utils.TestProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

    protected String takeScreenshot(WebDriver driver) {
        String filePath;
        try {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss-S");
            String fileName = dateFormat.format(date);
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            filePath = System.getProperty("user.dir") + "/target/screenshots/" + fileName + ".png";
            File destinationFile = new File(filePath);
            FileUtils.copyFile(source, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }
}
