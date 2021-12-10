package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions (features = {"./src/test/java/features/Login.feature"},
glue = {"stepDefinitions"})
public class RunnerJUnit  {

}
