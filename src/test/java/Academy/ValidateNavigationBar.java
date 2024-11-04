package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import pageObject.LandingPage;   
import resources.Base;

import java.io.IOException;

// Class to validate the presence of the navigation bar on the landing page
public class ValidateNavigationBar extends Base
{
    // WebDriver instance used for browser interactions
    public WebDriver driver;

    // Method to set up the browser and navigate to the URL before running the test
    @BeforeTest
    public void BrowserLaunch() throws IOException
    {
        // Initialize the WebDriver using the Base class method
        driver = initializeDriver();
        // Navigate to the URL specified in the properties file
        driver.get(Prop.getProperty("url"));
        // Maximize the browser window for better view
        driver.manage().window().maximize();    
    }

    // Test method to validate if the navigation bar is displayed on the landing page
    @Test
    public void basePageNavigation() throws IOException
    {
        // Create an instance of LandingPage to interact with page elements
        LandingPage l = new LandingPage(driver);
        
        // Assert that the navigation bar is displayed on the page
        AssertJUnit.assertTrue(l.GetNavigationbar().isDisplayed());
    }
    
    // Method to close the browser after the test completes
    @AfterTest
    public void BrowserClose()
    {
        // Close the browser window
        driver.close();
    }
}