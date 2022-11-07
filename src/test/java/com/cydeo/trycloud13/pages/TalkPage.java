package com.cydeo.trycloud13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkPage extends BasePage {

    @FindBy (xpath = "//ul[@class='conversations']//div[@class='acli__content__line-one']/span[1]")
    public List<WebElement> userList;

    @FindBy (xpath = "//div[@role='textbox']")
    public WebElement textBox;

    @FindBy (xpath = "//button[@aria-label='Send message']")
    public WebElement sendMessage;


}
