package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{



    @FindBy (id = "user")
    public WebElement userName;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (id = "submit-form")
    public WebElement loginButton;


    public void loginToPage(String login, String pass) {

        userName.sendKeys(login);
        password.sendKeys(pass);
        loginButton.click();
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputUser;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement logInBtn;

}
