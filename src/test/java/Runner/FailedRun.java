package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
     dryRun = false,
     monochrome = true,
     features = {"@target/failedrerun.txt"},
     glue= {"StepDefinition"},
     plugin= {"pretty","html:target/report/cucumber.html",
    		 "json:target/cucumber1.json",
    		 "rerun:target/failedrerun.txt"}
)
public class FailedRun {

}
