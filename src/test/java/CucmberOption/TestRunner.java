package CucmberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// The CucumberOptions annotation specifies the feature file and step definitions
@CucumberOptions(
        features = "src/test/java/Fetures/login.feature", // Path to the feature file
        glue = "StepDefination" // Package containing step definitions
)
public class TestRunner extends AbstractTestNGCucumberTests
{
    // No additional code needed here as AbstractTestNGCucumberTests takes care of running the tests
}