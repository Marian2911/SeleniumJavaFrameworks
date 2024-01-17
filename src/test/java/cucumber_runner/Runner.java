package cucumber_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(                                          //       Cucumber cu TestNG     !!! .
		features="src/test/java/cucumber_features",        
		glue="cucumber_stepdefinitions")
public class Runner extends AbstractTestNGCucumberTests {

}
