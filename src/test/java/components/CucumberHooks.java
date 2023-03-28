package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import resources.utils.ExtentReportCucumber;
import resources.utils.ExtentReportNG;

public class CucumberHooks extends BaseTest {
    ExtentReports extent = ExtentReportCucumber.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Before
    public void beforeScenario(Scenario scenario){
        test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @After
    public void afterScenario(Scenario scenario){
        //extentTest.get().fail(result.getThrowable());
        if(scenario.isFailed()){
            extentTest.get().fail("Failed");
        }
        else {
            extentTest.get().pass("Passed");
        }
        driver.close();
        extent.flush();
    }

}
