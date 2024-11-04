package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LandingPage;   
import resources.Base;

import java.io.IOException;

// Class to validate titles on the landing page
public class ValidateTitle extends Base
{
    // Instance of LandingPage to interact with the page elements
    LandingPage l;
    // WebDriver instance for browser interactions
    public WebDriver driver;
    // Logger for recording log information
    public static Logger log = LogManager.getLogger(Base.class.getName());
    
    // Method to set up the browser and navigate to the URL before running the tests
    @BeforeTest
    public void BrowserLaunch() throws IOException
    {
        // Initialize the WebDriver using the Base class method
        driver = initializeDriver();
        log.info("Driver is initialized");
        // Navigate to the URL specified in the properties file
        driver.get(Prop.getProperty("url"));
        log.info("Website is open");
        // Maximize the browser window for better visibility
        driver.manage().window().maximize();        
    }
    
    // Test method to validate the main page title text
    @Test
    public void basePageTitle() throws IOException
    {
        // Create an instance of LandingPage to access page methods
        l = new LandingPage(driver);
        // Get the title text from the page
        String text_title = l.getTitle().getText();
        // Print the title for verification
        System.out.println(text_title);
        // Assert that the title text matches the expected value
        Assert.assertEquals(text_title, "This is a dummy website for Web Automation Testing");
        log.info("Successfully validated text message");
    }
    
    // Test method to validate the ad title text
    @Test
    public void AdTitle()
    {
        // Create an instance of LandingPage to access page methods
        l = new LandingPage(driver);
        // Assert that the ad title text matches the expected value
        Assert.assertEquals(l.getAdTitle().getText(), "Upto 50% Off on Fully Automatic Top Load Washing Machine");
    }
    
    // Method to close the browser after the tests complete
    @AfterTest
    public void BrowserClose()
    {
        // Close the browser window
        driver.close();
    }
}