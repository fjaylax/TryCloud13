package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    WebElement element;

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionIconsList;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement favoriteOptionFromThreeDots;

    @FindBy(xpath = "//span[@class='icon icon-starred']")
    public WebElement favoriteOptionFromThreeDots2;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favoritesBtn;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> objectsFilesList;

    @FindBy(xpath = "//a[@data-action='Favorite']//span[2]")
    public WebElement removeFromFavorites;

    public static WebElement chooseInThreeDotsOption(String string) {
//        String locator = "//a[@data-action='" + string + "']";
        String locator = "//span[.='" + string + "']/..";
        WebElement chooseInThreeDotsOption = Driver.getDriver().findElement(By.xpath(locator));
        return chooseInThreeDotsOption;
    }

    public static WebElement leftSideMenu(String string) {
//        String locator = "//a[@data-action='" + string + "']";
        String locator = "//a[.='" + string + "']";
        WebElement leftSideMenu = Driver.getDriver().findElement(By.xpath(locator));
        return leftSideMenu;
    }


}
