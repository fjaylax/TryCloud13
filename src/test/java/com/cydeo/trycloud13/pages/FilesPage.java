package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.step_definitions.TS_13_5_AddFileToFavorites_StepDef;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilesPage {
    static WebElement chosenFile;
    WebElement element;
    static String chosenFileText;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);



    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionIconsList;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement favoriteOptionFromThreeDots;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> objectsFilesList;

    public static WebElement leftSideMenu(String string) {
        String locator = "//a[.='" + string + "']";
        WebElement leftSideMenu = Driver.getDriver().findElement(By.xpath(locator));
        return leftSideMenu;
    }
    public static WebElement actionIconsListMethod() {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        List<WebElement> actionIconsList = Driver.getDriver().findElements(By.xpath("//a[@class='action action-menu permanent']"));
        List<WebElement> objectsFilesList = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//span[@class='innernametext']"));
        int num = faker.number().numberBetween(1, actionIconsList.size());
        WebElement elementOfTheeDots;
        for (int i = 1; i <= actionIconsList.size(); i++) {
            if (i == num) {
                chosenFile = objectsFilesList.get(i);
                elementOfTheeDots = actionIconsList.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(elementOfTheeDots));
                elementOfTheeDots.click();
            }
        }
        return chosenFile;
    }

    public static String user_choose_the_option() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        chosenFileText = actionIconsListMethod().getText();
        String chosen = "";
        WebElement elementAddFavorites = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        if (elementAddFavorites.getText().equalsIgnoreCase("Remove from favorites")) {
            wait.until(ExpectedConditions.elementToBeClickable(elementAddFavorites));
            elementAddFavorites.click();
            return user_choose_the_option();
        } else if (elementAddFavorites.getText().equals("Add to favorites")) {
            wait.until(ExpectedConditions.elementToBeClickable(elementAddFavorites));
            elementAddFavorites.click();
            chosen = chosenFileText;
            return chosen;
        }
        return chosen;
    }
}



