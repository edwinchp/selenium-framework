package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.Page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class CategoryPage extends Page {
    private WebDriver driver;

    public CategoryPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void addNewCategory(String categoryName){
        click(By.xpath("//span[@class='btn btn-primary']"));
        type(By.xpath("//input[@id='nombreCategoria']"), categoryName);
        click(By.xpath("//button[@id='btnGuardarCategoria']"));
        click(By.xpath("//button[normalize-space()='OK']"));
        click(By.xpath("//div[@id='modalAgregarCategoria']//button[@type='button'][normalize-space()='Cerrar']"));
    }

    public void searchCategory(String categoryName){
        type(By.xpath("//input[@type='search']"), categoryName);
    }

    public List<String> getSearchResults(){
        List<WebElement> webElements = driver.findElements(By.xpath("//table//tr/td[count(preceding-sibling::td)+1 = count(ancestor::table/thead/tr/th[.='Nombre']/preceding-sibling::th)+1]"));
        return webElements.stream().map(WebElement::getText).toList();
    }


}
