package com.cydeo.tests.day02;

import com.cydeo.Utilities.DemoUtility;
import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoblazeTest {
    /*
    Test Case 1
    Navigate to : https://demoblaze.com/index.html
    Click on Laptops category
    Click on Sony vaio 5
    Click on Add to cart
    Handle Alert
    Verify product is in the Cart
    Test Case 2
    Navigate to : https://demoblaze.com/index.html
    Click on Phone category
    Click on Samsung galaxy s6
    Click on Add to cart
    Handle Alert
    Verify product is in the Cart
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    /*
    Create a utility method for this application that clicks on all the elements in the page when a string provided
     */

    @Test
    public void laptopTest(){
        // click on Laptops
        DemoUtility.clickLink(driver,"Laptops");

        // click on Sony Vaio 5
        DemoUtility.clickLink(driver,"Sony vaio i5");

        // click on Add to cart
        DemoUtility.clickLink(driver,"Add to cart");

        // If they ask you if you use polymorphism in your project
        DemoUtility.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // go to Cart
        DemoUtility.clickLink(driver,"Cart");

        // verify that product is added: locate Delete element and verify that is Displayed
        Assert.assertTrue(driver.findElement(By.linkText("Delete")).isDisplayed());
    }

    @Test
    public void phoneTest(){
        // click on Phone
        DemoUtility.clickLink(driver,"Phone");

        // click on Samsung galaxy s6
        DemoUtility.clickLink(driver,"Samsung galaxy s6");

        // click on Add to cart
        DemoUtility.clickLink(driver,"Add to cart");

        // If they ask you if you use polymorphism in your project
        DemoUtility.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // go to Cart
        DemoUtility.clickLink(driver,"Cart");

        // verify that product is added: locate Delete element and verify that is Displayed
        Assert.assertTrue(driver.findElement(By.linkText("Delete")).isDisplayed());
    }
}
