package StepDefination;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import pageObject.LogingPage;
import pageObject.PortalHomePage;
import resources.Base;

public class StepDefination extends Base
{
	// Step definition for initializing the Chrome browser
	@Given("Initialize browser with chrome")
	public void initialize_browser_with_chrome() throws IOException 
	{
	    // Initialize the WebDriver instance and maximize the browser window
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	
	// Step definition for navigating to a specified site
	@Given("Navigate to {string} site")
	public void navigate_to_site(String Arg1) 
	{
		// Use the provided URL to navigate to the desired website
		driver.get(Arg1);
	}
	
	// Step definition for clicking on the login link in the landing page
	@Given("Click on login link")
	public void click_on_login_link() 
	{
		// Create an instance of the LandingPage object and perform login actions
		LandingPage l = new LandingPage(driver);
		l.MyAccount(); // Click on 'My Account'
		l.Login();     // Click on 'Login'
		// Optional: Print message for debugging
		// System.out.println("click on login link");
	}
	
	// Step definition for entering user credentials
	@When("User enter {string} and {string}")
    public void user_enter_credentials(String id, String password) 
	{
		// Create an instance of the LogingPage object and input credentials
		LogingPage lp = new LogingPage(driver);
		lp.Add_username().sendKeys(id);    // Enter username
		lp.Add_password().sendKeys(password); // Enter password
		lp.clickLoginbtn().click();        // Click the login button
		// Optional: Print message for debugging
		// System.out.println("successfully login");
    }

	// Step definition for verifying navigation to the main page
	@Then("User navigate to main page")
	public void user_navigate_to_main_page() 
	{
		// Create an instance of the PortalHomePage object and verify the account heading
		PortalHomePage ph = new PortalHomePage(driver);
		System.out.println(ph.get_account_option_heading().getText()); // Print account option heading
		driver.close(); // Close the browser tab
	}
	
	// Step definition for closing the browser
	@Then("close browser")
	public void close_browser()
	{
		// Quit the WebDriver and close all associated windows
		driver.quit();
	}
} 