package com.cydeo.trycloud13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
