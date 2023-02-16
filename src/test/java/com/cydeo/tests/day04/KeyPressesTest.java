package com.cydeo.tests.day04;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTest extends CydeoAppTestBase{
    @Test
    public void TC02(){
        KeyPressesPage keyPressesPage = new KeyPressesPage();

        keyPressesPage.clickOption("Key Presses");

        // click on shift button
        Actions actions = new Actions(Driver.getDriver()); // to send keyboard action
        actions.sendKeys(Keys.SHIFT).perform();

        // verify the text has SHIFT in it

        Assert.assertTrue(keyPressesPage.result.getText().contains("SHIFT"));


        // click on TAB
        actions.sendKeys(Keys.TAB).perform();

        Assert.assertTrue(keyPressesPage.result.getText().contains("TAB"));
    }
}
