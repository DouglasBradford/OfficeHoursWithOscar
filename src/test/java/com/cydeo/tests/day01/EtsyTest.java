package com.cydeo.tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTest {
    public static void main(String[] args) {
        //go to etsy
        //locate help center link and click
        //verify that url contains "help"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");

        //using xpath and the text of the element
        //WebElement helpLink = driver.findElement(By.xpath("//a[.='Go toHelp Center']")); //poor approach

        WebElement helpLink = driver.findElement(By.partialLinkText("Help Center"));
        helpLink.click();
        if (driver.getCurrentUrl().contains("help")){
            System.out.println("PASSED");
        }


    }
}
