
package Academy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

// Class definition for implementing TestNG listeners for test execution tracking
public class Listeners extends Base implements ITestListener
{
    // Method that runs when a test starts
    @Override
    public void onTestStart(ITestResult result) 
    {
        // This method is invoked when a test method is about to start
    }

    // Method that runs when a test passes successfully
    @Override
    public void onTestSuccess(ITestResult result) 
    {
        // This method is invoked when a test method completes successfully
    }

    // Method that runs when a test fails
    @Override
    public void onTestFailure(ITestResult result) 
    {
        // This method is invoked when a test method fails
        // Capture a screenshot upon test failure
        WebDriver driver = null;

        // Get the name of the failed method
        String FailMethodname = result.getMethod().getMethodName();
        
        try 
        {
            // Get the WebDriver instance from the test class using reflection
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } 
        catch (Exception e) 
        {
            // Print the stack trace if there is an exception
            e.printStackTrace();
        }

        try 
        {
            // Capture a screenshot and save it to the specified path
            getScreenShotPath(FailMethodname, driver);
        } 
        catch (IOException e) 
        {
            // Print the stack trace if there is an IOException
            e.printStackTrace();
        }
    }

    // Method that runs when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) 
    {
        // This method is invoked when a test method is skipped
    }

    // Method that runs when a test fails but is within the success percentage
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
        // This method is invoked when a test fails but is within the success ratio defined
    }

    // Method that runs when a test fails due to a timeout
    @Override
    public void onTestFailedWithTimeout(ITestResult result) 
    {
        // This method is invoked when a test fails due to a timeout
    }

    // Method that runs when the test suite starts
    @Override
    public void onStart(ITestContext context) 
    {
        // This method is invoked when the test suite starts
    }

    // Method that runs when the test suite finishes
    @Override
    public void onFinish(ITestContext context) 
    {
        // This method is invoked when the test suite finishes
    }
}