package com.cydeo.tests.day04;

import com.cydeo.Utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CydeoAppTestBase {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        /*
        since our driver is null, it will create and set up window and time
        then navigate to given URL
         */
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
