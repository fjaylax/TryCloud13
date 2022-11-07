package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//a[@aria-label='Files'])[1]")
    public WebElement filesBtn;

    /**
     * Method for choose required option from the List of webElements on left top side
     * @param string
     */

    public static void chooseTheMenu(String string) {
        String locator = "(//a[@aria-label='" + string + "'])[1]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }
}
