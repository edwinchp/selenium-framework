package pages.base;

import components.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import resources.utils.TestProperties;
import resources.utils.Wait;

import java.io.IOException;
import java.util.Properties;

public class Page {

    WebDriver driver;
    Wait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(this.driver);
    }
    protected void type(By ele, String text){
        wait.untilIsClickable(ele).sendKeys(text);
    }

    protected void click(By ele){
        wait.untilIsClickable(ele).click();
    }

    protected boolean isDisplayed(By ele){
        return wait.untilIsDisplayed(ele).isDisplayed();
    }

    protected String getText(By ele){
        return wait.untilIsDisplayed((ele)).getText();
    }
}
