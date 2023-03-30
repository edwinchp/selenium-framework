package cucumber;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/java/cucumber", glue = {"steps", "components"}, monochrome = true, plugin = {"html:target/cucumber.html"})
public class TestNGRunner  extends AbstractTestNGCucumberTests {

}
