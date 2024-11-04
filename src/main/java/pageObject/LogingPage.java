package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogingPage
{
    WebDriver driver;

    // Locators for the UI elements
    By Email_id = By.xpath("//input[@id='input-email']");
    By pass = By.xpath("//input[@id='input-password']");
    By Login_btn = By.xpath("//input[@value='Login']");

    public LogingPage(WebDriver driver)
    {
        // Constructor to initialize the WebDriver instance
        this.driver = driver;
        // End of block
    }

    // Method to get the username input field
    public WebElement Add_username()
    {
        // Return statement
        return driver.findElement(Email_id);
    }

    // Method to get the password input field
    public WebElement Add_password()
    {
        // Return statement
        return driver.findElement(pass);
    }

    // Method to get the login button
    public WebElement clickLoginbtn()
    {
        // Return statement
        return driver.findElement(Login_btn);
    }
}