package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Base 
{
    // WebDriver instance for browser interactions
	public WebDriver driver;
	
    // Properties object for reading configuration files
	public Properties Prop;
	
    // Method to initialize the WebDriver based on the browser specified in properties
	public WebDriver initializeDriver() throws IOException
	{
        // Load the properties file to get browser configurations
		Prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//Data.properites");
		Prop.load(fis);
		 // Uncomment when running tests from command line or Jenkins
        // String browsername = System.getProperty("browser");

        // Get browser name from properties file
		
		String browsername = Prop.getProperty("browser");
		System.out.println("hello"+browsername);
		
        // Check for Chrome browser and optional headless mode
		if(browsername.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			if(browsername.contains("headless"))
			{
                // Add headless argument for headless mode
				option.addArguments("headless");
			} 
            // Initialize ChromeDriver with options
			driver=new ChromeDriver(option); 
		}
		else if(browsername.equals("firefox"))
		{
            // Code for initializing Firefox browser
		}
		else if(browsername.equals("IE"))
		{
            // Code for initializing Internet Explorer browser
		}
        // Set implicit wait for driver actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
    // Method to take a screenshot and save it with the test case name
	public void getScreenShotPath(String testcasename,WebDriver driver) throws IOException
	{
        // Cast WebDriver instance to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
        // Capture screenshot and store it as a file
		File source = ts.getScreenshotAs(OutputType.FILE);
        // Define the destination path for the screenshot
		String Destinationfile = System.getProperty("user.dir")+"//reports//"+testcasename+".png";
        // Copy the screenshot to the specified location
		FileUtils.copyFile(source, new File(Destinationfile));
	}
}
