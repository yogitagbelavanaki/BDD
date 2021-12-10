package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"./src/test/java/features/Login.feature",},
glue = {"stepDefinitions"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

}
