import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Kie on 05.09.2016.
 */

@RunWith(Cucumber.class)
    @CucumberOptions(
            monochrome = true,
            features = "src/main/java/features",
            plugin = {"pretty", "html:target/cucumber-html-report"},
            //glue = " ",
            tags = "@test"
    )
    public class RunnerAllTest  extends AbstractTestNGCucumberTests {

    }

