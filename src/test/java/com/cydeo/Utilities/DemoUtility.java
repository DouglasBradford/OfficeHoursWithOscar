package com.cydeo.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoUtility {
    public static void clickLink(WebDriver driver, String str){
        driver.findElement(By.partialLinkText(str)).click();
        wait(1);
    }

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
