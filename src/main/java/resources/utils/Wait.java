package resources.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Wait {
    private FluentWait<WebDriver> wait;

    public Wait(WebDriver driver, int seconds){
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(200));
    }

    public WebElement untilIsDisplayed(By ele){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }

    public WebElement untilIsClickable(By ele){
        return wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
}
