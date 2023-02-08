package com.cydeo.tests.day03;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class VytrackProjectTestBase {
    WebDriver driver;  // attribute of parent class
    WebDriverWait wait;
    // runs before every @Test method
    @BeforeMethod
    public void setUp(){ // action of parent class
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // define implicitly wait: it is enough to declare just once, it will be used by all test methods and lines of code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://vytrack.com/");
    }

    @AfterMethod
    public void tearDown(){
        // usually we define taking screenshot of failure
        driver.close();
    }
}
