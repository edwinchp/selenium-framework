package cucumber;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/cucumber", glue = {"steps", "components"}, monochrome = true, plugin = {"html:target/cucumber.html", "extent.reporter.spark.vieworder=dashboard,test,category,exception,author,device,log"})
public class TestNGRunner  extends AbstractTestNGCucumberTests {

}
