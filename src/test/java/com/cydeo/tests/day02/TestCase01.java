package com.cydeo.tests.day02;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase01 {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
*** the rest of the steps will be done after everybody watches Java Faker class video
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
     */
    WebDriver driver;  // declare object globally so I can use at following methods such as @Test, @AfterClass
    @BeforeClass
    public void testSetup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }
    @AfterClass
    public void tearDownTest(){
        driver.close();
    }

    @Test
    public void signUpTest(){
        // Verify that home page is visible successfully
        String expectedResult = "Automation Exercise";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"Home Page is NOT displayed correctly");
        // since we will see the message only if the step fails, we can provide a negative explanation to make it more meaningful

        // get the text of element which is only at home page
        WebElement advertisementElement = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(advertisementElement.isDisplayed(),"Home Page is NOT displayed correctly");

        // Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.partialLinkText("Signup"));
        signUp.click();

        // Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//div[@class='signup-form']//h2"));
        Assert.assertTrue(newUser.isDisplayed(),"New User element is NOT displayed");

        //driver.findElement(By.className("col-sm-3 col-sm-offset-1")) --> will give error
        // driver.findElement(By.xpath("//div[@class='col-sm-3 col-sm-offset-1']")) --> this is OK

        // Enter name and email address:

        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameBox.sendKeys("Lebron James");

        // if your application is sending verification to your email provided, you can create a disposable email address from various providers temporarily, this is a common approach in the market as well.
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailBox.sendKeys("lebronJames@trashmail.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // assertion of next page
        Assert.assertTrue(driver.findElement(By.xpath("//h2/b[.='Enter Account Information']")).isDisplayed());

    }

}