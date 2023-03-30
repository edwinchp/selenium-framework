package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import resources.utils.ExtentReportCucumber;

import java.lang.annotation.Annotation;

public class CucumberHooks extends BaseTest {
    static ExtentReports extent;
    ExtentTest test;

    
    @BeforeAll
    public static void beforeScenario(){
        extent = ExtentReportCucumber.getReportObject();
    }

    @After()
    public void afterScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        if(scenario.isFailed()){
            test.fail("Error");
        }
        else {
            test.pass("Correcto");
        }
        extent.flush();
    }
}