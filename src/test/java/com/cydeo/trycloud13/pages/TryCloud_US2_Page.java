package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryCloud_US2_Page {
    public TryCloud_US2_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userNameBtn;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBtn;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongMessage;

    public void login(String username, String password) {
        userNameBtn.sendKeys(username);
        passwordBtn.sendKeys(password);
        loginBtn.click();

    }
}