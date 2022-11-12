package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
     dryRun = false,
     monochrome = true,
     features = {"src/test/resources/Features/Login.feature","src/test/resources/Features/ComposeMail.feature"},
     glue= {"StepDefinition"},
     tags= "@Smoke",
     plugin= {"pretty","html:target/report/cucumber.html","json:target/cucumber1.json"}
)
public class CucumberRunnerTest {

}
