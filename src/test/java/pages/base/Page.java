package pages.base;

import components.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }
    protected void type(By ele, String text){
        driver.findElement(ele).sendKeys(text);
    }

    protected void click(By ele){
        driver.findElement(ele).click();
    }

    protected boolean isDisplayed(By ele){
        return driver.findElement(ele).isDisplayed();
    }
}
