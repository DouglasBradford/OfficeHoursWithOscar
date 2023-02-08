package com.cydeo.tests.day03;

import com.cydeo.Utilities.VytrackUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackTestCases extends VytrackProjectTestBase{
    // child class can use attribute and action of parent class
    @Test
    public void TC01(){
        //    WebElement homeElement = driver.findElement(By.id("menu-item-844")); not useful, I need to locate the whole list
//    //ul[@id='top-menu']/li/a
        List<WebElement> topMenuElements = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));
        for (WebElement topMenuElement : topMenuElements) {
            Assert.assertTrue(topMenuElement.isDisplayed());
        }
        List<String> expectedTopMenuList = new ArrayList<>(Arrays.asList("Home","About us","Our Approach","Products and Services","Contact","LOGIN"));
// I can use a utility method that turns list of Webelement into List of String
        List<String> actualTopMenuList = VytrackUtility.getElementsText(topMenuElements);
        Assert.assertEquals(actualTopMenuList,expectedTopMenuList); // compare String to String, 1 assertion
    }
    @Test
    public void TC02() throws InterruptedException {
//   //ul[@id='top-menu']//li[contains(.,'Our')]//ul/li
        //    //ul[@id='top-menu']/li[@id='menu-item-845']//li/a  we will use this one

        WebElement topMenuOurApproach = driver.findElement(By.xpath("//ul[@id='top-menu']//li[contains(.,'Our')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(topMenuOurApproach).perform();
        Thread.sleep(3000);

        //    List<String> actualMenuText = VytrackUtility.getElementsText(driver.findElements(By.xpath("//ul[@id='top-menu']/li[@id='menu-item-845']//li/a")));
        List<WebElement> actualMenuElements = driver.findElements(By.xpath("//ul[@id='top-menu']/li[@id='menu-item-845']//li/a"));
        for (WebElement actualMenuElement : actualMenuElements) {
            Assert.assertTrue(actualMenuElement.isDisplayed()); // 4 times assertions happen
        }
    }
    @Test
    public void TC03(){
        // click on Products and Service
        driver.findElement(By.xpath("//ul[@id='top-menu']/li[@id='menu-item-846']/a")).click();

        driver.findElement(By.xpath("//li[@id='menu-item-861']/a")).click();
        // Verify the page and label
        String expectedUrl = "fleet-analysis-and-optimization";

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));

    }

    @Test
    public void LoginTest(){
        driver.findElement(By.linkText("LOGIN")).click();

        // to enter username
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        // to enter password
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);


        WebElement userElement = driver.findElement(By.xpath("//li[@id='user-menu']//a[@class='dropdown-toggle']"));

        // explicit wait: create an object of wait
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userElement));
        Assert.assertTrue(userElement.isDisplayed());

        System.out.println(userElement.getText());

    }
}
