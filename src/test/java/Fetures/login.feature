Feature: Login into application

Scenario Outline: Positive test validation login
Given Initialize browser with chrome
And Navigate to "https://ecommerce-playground.lambdatest.io/index.php" site
And Click on login link
When User enter <Id> and <password>
Then User navigate to main page
Then close browser

Examples:
|Id                           |password       |
|"khansara231992@gmail.com"   |"1992@December"|      
 