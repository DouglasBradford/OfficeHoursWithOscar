package com.cydeo.tests.day04;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends CydeoAppTestBase{
    // use TestBase for before and after methods
    @Test
    public void TC01(){

        HoverPage hoverPage = new HoverPage();

        hoverPage.clickOption("Hovers");

        // BAD PRACTICE created by Oscar
//        int index = 1;
//        // Verify user1 , user2 , user3 is displaying
//        for(WebElement eachImage: hoverPage.images){
//            hoverPage.hoverOverElement(eachImage); // hover overing on the each image
//            // make string concat
//            String nameLocator = "//h5[text()='name: user"+index+"']"; // for first pic 1, second 2
//            index++;
//            WebElement nameElement = Driver.getDriver().findElement(By.xpath(nameLocator));
//            Assert.assertTrue(nameElement.isDisplayed());
//        }

        // POM created by Software people
        for (int i = 0; i < hoverPage.images.size(); i++) {
            hoverPage.hoverOverElement(hoverPage.images.get(i));
            Assert.assertTrue(hoverPage.names.get(i).isDisplayed());
        }

    }
}
