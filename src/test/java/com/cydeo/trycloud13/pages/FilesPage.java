package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilesPage extends BasePage {

    @FindBy (xpath = "//a[@class='button new']")
    public WebElement buttonAddNewFile;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement inputFileLocator;

    @FindBy (id = "uploadprogressbar")
    public WebElement progressBar;

    @FindBy (xpath = "(//a[@data-action='menu'])[1]")
    public WebElement actionMenu;

    @FindBy (xpath = "//div[@id='rightClickMenu']//li[@class='action-0']")
    public WebElement removeFromFavoriteOption;

    @FindBy (xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement leftFavoriteModule;

    @FindBy (xpath = "//div[@id='content']/div/ul/li/a")
    public List<WebElement> leftMenuModules;

    @FindBy (xpath = "//table/tbody/tr/td[2]/a/span/span[1]")
    public List<WebElement> listOfFilesNames;

    @FindBy (xpath = "//table/tbody/tr/td[2]/a/div/div/div")  // Favorited / Not favorited
    public List<WebElement> listOfFavorites;

    @FindBy (xpath = "//a[@data-action='menu']")
    public List<WebElement> clickableDots;

    @FindBy (xpath = "//table[@class='list-container']/tbody/tr")
    public List<WebElement> favoriteFileNames;






     

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionIconsList;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement favoriteOptionFromThreeDots;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> objectsFilesList;

    @FindBy(css = "button[class=settings-button]")
    public WebElement settingButton;

    @FindBy(xpath = "//input[@class='checkbox']/following-sibling::label")
    public List<WebElement> listOfSettingOptions;

    @FindBy(xpath = "//a[@class='icon-quota svg']//p")
    public WebElement currentStorageSpace;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement uploadFileOption;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFile;


    /**
     * Method for choose element from the left side on files page
     * @param string
     * @return WebElement
     */

    public static WebElement leftSideMenu(String string) {
        String locator = "//a[.='" + string + "']";
        WebElement webElement = Driver.getDriver().findElement(By.xpath(locator));
        return webElement;
    }

    /**
     * Method for choose element from popup menu after click three dots on files page
     * @param string
     * @return WebElement
     */
    public static WebElement popupMenu(String string) {
        String locator = "//span[.='" + string + "']/..";
        WebElement webElement = Driver.getDriver().findElement(By.xpath(locator));
        return webElement;
    }


}




