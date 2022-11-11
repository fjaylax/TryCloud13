package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TryCloud_US13_Page {
    public TryCloud_US13_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userNameBtn;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBtn;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Dashboard']")
    public WebElement dashboardModule;

@FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Contacts']")
    public WebElement contactModule;

@FindBy (xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactList;

}
