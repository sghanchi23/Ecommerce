package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage 
{
    // WebDriver instance used for interacting with the web page
	public WebDriver driver;
		
    // Locator for the "My Account" heading
	By account_heading= By.xpath("//h2[text()='My Account']");
	
    // Constructor to initialize the WebDriver instance
	public PortalHomePage(WebDriver driver) 
	{
        // Assign the passed WebDriver instance to the class instance
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


    // Method to get the "My Account" heading element from the page
	public WebElement get_account_option_heading()
	{
        // Return the located WebElement for the account heading
		return driver.findElement(account_heading);
	}
}
