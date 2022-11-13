package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (id= "user")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement passcode;

    @FindBy(id = "submit-form")
    public WebElement logIn;

    @FindBy(xpath = "(//a[@aria-label='Dashboard'])[1]")
    public WebElement dashboard;


}
