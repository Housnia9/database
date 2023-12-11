package najah;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="testcase",glue = "najah",
plugin = {"html: target/cucumber-reports.html"}
)
public class acceptancetest {


}
