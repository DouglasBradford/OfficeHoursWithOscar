package com.cydeo.tests.day01;

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

        if(!actualUrl.contains(expectedText)){
            System.err.println("FAILED on URL verification of Facebook");
            System.exit(-1);
        }



        // Verify title contains Facebook
        if(!driver.getTitle().contains("Facebook")){
            System.err.println("FAILED on Title verification of Facebook");
            System.exit(-1);
        }

        // Navigate to https://www.google.com
        driver.navigate().to("https://www.google.com");

        // Verify url contains google
        if(!driver.getCurrentUrl().contains("google")){
            System.err.println("FAILED on URL verification of Google");
            System.exit(-1);
        }

        if(!driver.getTitle().contains("Google")){
            System.err.println("FAILED on Title verification of Google");
            System.exit(-1);
        }

        driver.navigate().back(); // back to Facebook
        // Verify title contains Facebook
        if(!driver.getTitle().contains("Facebook")){
            System.err.println("FAILED on Title verification of Facebook");
            System.exit(-1);
        }

        driver.navigate().forward(); // go to google again
        if(!driver.getCurrentUrl().contains("google")){
            System.err.println("FAILED on URL verification of Google");
            System.exit(-1);
        }


        driver.close();
    }
}
