package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//ul[@id='appmenu']/li/a")
    public List<WebElement> upMenuModules;


    public static void chooseTheMenu(String string) {
        String locator = "(//a[@aria-label='" + string + "'])[1]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

}
