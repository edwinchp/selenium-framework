package resources.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir") + "//target//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Edwin Chi Pineiro");

        return extent;
    }
}
