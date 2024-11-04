package Academy;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.LandingPage;
import pageObject.LogingPage;
import resources.Base;

import java.io.IOException;

//Class definition for testing home page functionalities
public class HomePage extends Base
{
    // WebDriver instance used for browser interactions
	public WebDriver driver;

    // Logger instance for logging test activities
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
    // Method to launch the browser and set up the initial conditions
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
        // Initialize the WebDriver using the Base class method
		driver=initializeDriver();
		log.info("Driver is initialize ");
        // Maximize the browser window for better visibility	
		driver.manage().window().maximize();		
	}
	
    // Test method that navigates to the base page and performs login using provided data
	@Test(dataProvider="GetData")
	public void basePageNavigation(String username,String Pass) throws IOException
	{
        // Navigate to the specified URL
		driver.get(Prop.getProperty("url"));
		log.info("Website is open");

        // Create an instance of LandingPage to interact with page elements
		LandingPage l=new LandingPage(driver);
		l.MyAccount(); // Click on "My Account"
	    l.Login(); // Click on "Login"
		System.out.println("click on login link");
		
		 // Create an instance of LogingPage to fill in login credentials
        LogingPage lp = new LogingPage(driver);
        lp.Add_username().sendKeys(username); // Enter the username
        lp.Add_password().sendKeys(Pass); // Enter the password
        lp.clickLoginbtn().click(); // Click on the login button
        log.info("Successfully logged in");
    }

    // Method to close the browser after the test completes
    @AfterTest
    public void BrowserClose()
    {
        // Close the browser window
        driver.close();
    }

    // DataProvider method to supply login data for the test
    @DataProvider
    public Object[][] GetData()
    {
        // Create a 2D array for storing test data (rows = data sets, columns = values)
        Object data[][] = new Object[1][2];
        
        // 0th row: Test data with email and password
        data[0][0] = "AArti@gmail.com";
        data[0][1] = "Abc345j";
        
        // Additional data sets can be uncommented and added as needed
        // data[1][0] = "Email";
        // data[1][1] = "Password";
        
        return data; // Return the data array to be used by the test
    }
}

