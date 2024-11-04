package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Class definition
public class LandingPage
{
    // WebDriver instance used for interacting with the web page
	WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
		// Constructor to initialize the WebDriver instance		
		this.driver=driver;
        // End of block
	}
	
    // Locators for UI elements
	private By my_account=By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
	private By login_btn=By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a/div/span");
	
	private By title = By.xpath("//p[@class='m-0 font-size-sm']");
	private By navbar = By.xpath("//ul[@class='navbar-nav horizontal']"); 
	private By AdTitle= By.xpath("//div[@class='mb-4 mb-lg-0']//h4[contains(text(),'Upto 50% Off on Fully Automatic Top Load Washing Machine')]");

    // Method definitions and logic continue
	public void MyAccount()
	{
		Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(my_account)).moveToElement(driver.findElement(login_btn)).click().build().perform();
	}

	public WebElement Login()
	{
		return driver.findElement(login_btn);
        // Return statement
	}	
	public WebElement GetNavigationbar()
	{
		return driver.findElement(navbar);
        // Return statement
	}	
	public WebElement getTitle()
	{
		return driver.findElement(title);
        // Return statement
	}
	public WebElement getAdTitle()
	{
		return driver.findElement(AdTitle);
        // Return statement
	}
}
