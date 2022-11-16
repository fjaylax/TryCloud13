package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Us4Page {

    public Us4Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//ul[@id='appmenu']/li[2]")
    public WebElement filesBtn;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAll;

    @FindBy(xpath = "//label[contains(@for,'select-files')]/../input")
    public List<WebElement> checkFileButtons;








}
