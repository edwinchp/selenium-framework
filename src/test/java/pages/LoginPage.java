package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.Page;

public class LoginPage extends Page {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By usernameInput = By.id("login");
    By passwordInput = By.id("password");
    By loginButton = By.xpath("//input[@value='iniciar sesion']");
    By navbar = By.xpath("//nav[@class='navbar navbar-expand-lg navbar-dark bg-dark']");


    public void goTo(String url){
        driver.get(url);
    }

    public void typeUsername(String username){
        type(usernameInput, username);
    }

    public void typePassword(String password){
        type(passwordInput, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public boolean isNavbarDisplayed(){
        return isDisplayed(navbar);
    }

}
