package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import resources.utils.ExtentReportCucumber;

import java.lang.annotation.Annotation;

public class CucumberHooks extends BaseTest {
    ExtentReports extent = ExtentReportCucumber.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    
    @Before
    public void beforeScenario(Scenario scenario){
        test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @After()
    public void afterScenario(Scenario scenario){

        if(scenario.isFailed()){
            extentTest.get().fail("Failed");
        }
        else {
            extentTest.get().pass("Passed");
        }
        //driver.close();
        extent.flush();
    }
}