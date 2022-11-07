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

    /**
     * Method for chose random element of three dots from List and comparing with List of files names
     * @return String
     */
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
                BrowserUtils.sleep(1);
                wait.until(ExpectedConditions.elementToBeClickable(elementOfTheeDots));
                elementOfTheeDots.click();
            }
        }
        return chosenFile;
    }

    /**+
     * Name of file from List of files names what is added to Favorites
     * @return String
     */
    public static String user_choose_the_option() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        BrowserUtils.sleep(1);
        chosenFileText = actionIconsListMethod().getText();
        System.out.println("chosenFileText from Method = " + chosenFileText);
        String chosen = "";
        WebElement elementAddFavorites = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        System.out.println("elementAddFavorites from Method = " + elementAddFavorites.getText());
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



