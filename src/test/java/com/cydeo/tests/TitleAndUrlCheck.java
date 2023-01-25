package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleAndUrlCheck {

    /*
  TC #2: Title and Url check
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify url contains facebook
4. Verify title contains Facebook
5. Navigate to https://www.google.com
6. Verify url contains google
7. Verify title contains Google
8. Navigate back
9. Verify url contains facebook
10.Navigate forward
11.Verify url contains google
   */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        // 1. OS -windows, browser - chrome

        // creating our driver object for automation
        WebDriver driver = new ChromeDriver();

        // maximize the page
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String expectedText = "facebook";

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedText)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();
    }
}
