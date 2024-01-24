package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"pretty", "html:target/cucumber"},
	    features={"src/test/resources/FeatureFile/Capstone.feature"},
	    glue={"stepDefination"}
//	    dryRun = true
		
		)
public class TestRunner {
	   

}
