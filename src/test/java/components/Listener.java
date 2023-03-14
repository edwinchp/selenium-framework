package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.utils.ExtentReportNG;

public class Listener extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportNG.getReportObject();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result){
            test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Passed");

        try {
            WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            test.addScreenCaptureFromPath(takeScreenshot(driver), result.getMethod().getMethodName());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        try {
            WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            test.addScreenCaptureFromPath(takeScreenshot(driver), result.getMethod().getMethodName());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
