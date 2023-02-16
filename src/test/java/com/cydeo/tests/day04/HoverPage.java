package com.cydeo.tests.day04;

import com.cydeo.Utilities.DemoUtility;
import com.cydeo.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoverPage extends CydeoPracticePage{
    // this is child POM which is using the constructor of the parent abstract main page of the application; it does not need an extra constructor

    @FindBy(tagName = "img")     // to locate all images in hover page
    public List<WebElement> images;

    @FindBy(tagName = "h5")
    public List<WebElement> names;


    public void hoverOverElement(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
        DemoUtility.wait(2);
    }
}
