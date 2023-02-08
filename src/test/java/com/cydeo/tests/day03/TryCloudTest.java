package com.cydeo.tests.day03;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TryCloudTest {
    WebDriver driver;  // attribute of parent class
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // define implicitly wait: it is enough to declare just once, it will be used by all test methods and lines of code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://qa2.trycloud.net/index.php/login");
    }

    @AfterMethod
    public void tearDown(){
        // usually we define taking screenshot of failure
        driver.close();
    }
    @Test
    public void TC04(){
        String userName = "user1";
        String passWord = "UserUser123";
        WebElement userBox = driver.findElement(By.id("user"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        userBox.sendKeys(userName);
        passwordBox.sendKeys(passWord);

        // Verify that password is hidden
        String type = passwordBox.getAttribute("type");
        System.out.println("type = " + type);
        Assert.assertEquals(type,"password");

        // String passWordFromWebElement = passwordBox.getText(); // should give me nothing
        // String passWordFromWebElement = passwordBox.getAttribute("value"); // should give me nothing
        // System.out.println("passWordFromWebElement = " + passWordFromWebElement);


    }
}
