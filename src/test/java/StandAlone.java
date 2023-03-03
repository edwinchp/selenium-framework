import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class StandAlone {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http:localhost:8000");
        driver.findElement(By.id("login")).sendKeys("Secretario Edwin");
        driver.findElement(By.id("password")).sendKeys("vivacristorey");
        driver.findElement(By.xpath("//input[@value='iniciar sesion']")).click();
        System.out.println(driver.findElement(By.xpath("//nav[@class='navbar navbar-expand-lg navbar-dark bg-dark']")).isDisplayed());

        driver.quit();
    }
}
