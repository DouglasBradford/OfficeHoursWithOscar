package com.cydeo.tests.day04;

import com.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CydeoPracticePage {
    public CydeoPracticePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Home")
    public WebElement homeLink;

    // Create a method which is clickOption(String option) (use hover in method)
    public void clickOption(String optionText) {
        Driver.getDriver().findElement(By.partialLinkText(optionText)).click();
    }

}
