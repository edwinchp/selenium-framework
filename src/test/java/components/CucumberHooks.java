package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import resources.utils.ExtentReportCucumber;
import resources.utils.Helper;

public class CucumberHooks extends BaseTest {
    static ExtentReports extent;
    ExtentTest test;

    
    @BeforeAll
    public static void beforeAll(){
        extent = ExtentReportCucumber.getReportObject();
    }

    @Before
    public static void beforeScenario(){
        Helper.setUpDriver();
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
        Helper.tearDownDriver();
    }
}