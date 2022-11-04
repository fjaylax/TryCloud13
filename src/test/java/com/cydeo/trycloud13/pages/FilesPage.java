package com.cydeo.trycloud13.pages;

import com.cydeo.trycloud13.step_definitions.TS_13_5_AddFileToFavorites_StepDef;
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

    public static WebElement chooseInThreeDotsOption1(String string) {
//        String locator = "//a[@data-action='" + string + "']";
        String locator = "//span[.='" + string + "']/..";
        WebElement chooseInThreeDotsOption = Driver.getDriver().findElement(By.xpath(locator));
        return chooseInThreeDotsOption;
    }

//    public  WebElement chooseInThreeDotsOption() {
////        String locator = "//a[@data-action='" + string + "']";
//        String locator = "//a[@class='menuitem action action-favorite permanent']";
//        WebElement chooseInThreeDotsOption = Driver.getDriver().findElement(By.xpath(locator));
//        if (chooseInThreeDotsOption.getText().equals("Remove from favorites")) {
//            BrowserUtils.sleep(3);
//            chooseInThreeDotsOption.click();
////            actions.moveToElement(FilesPage.chooseInThreeDotsOption("Remove from favorites")).click().perform();
//
//
////            elementOfTheeDots.click();
////            actions.moveToElement(FilesPage.chooseInThreeDotsOption(string)).click().perform();
//        }else if (chooseInThreeDotsOption.getText().equals("Add to favorites")){
//            BrowserUtils.sleep(3);
////            actions.moveToElement(filesPage.removeFromFavorites).click().perform();
//            //           FilesPage.chooseInThreeDotsOption(string).click();
////            actions.moveToElement(FilesPage.chooseInThreeDotsOption(string)).click().perform();
////            actions.moveToElement(FilesPage.chooseInThreeDotsOption()).click().perform();
//            chooseInThreeDotsOption.click();
//        }
//        return chooseInThreeDotsOption;
//    }

    public static WebElement leftSideMenu(String string) {
        String locator = "//a[.='" + string + "']";
        WebElement leftSideMenu = Driver.getDriver().findElement(By.xpath(locator));
        return leftSideMenu;
    }

    public static WebElement actionIconsListMethod() {
        Faker faker = new Faker();
        List<WebElement> actionIconsList = Driver.getDriver().findElements(By.xpath("//a[@class='action action-menu permanent']"));
        List<WebElement> objectsFilesList = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//span[@class='innernametext']"));
        int num = faker.number().numberBetween(1, actionIconsList.size());
        WebElement chosenFile = null;
        WebElement elementOfTheeDots;
        for (int i = 1; i <= actionIconsList.size(); i++) {
            if (i == num) {
                chosenFile = objectsFilesList.get(i);
                elementOfTheeDots = actionIconsList.get(i);
                elementOfTheeDots.click();
            }
        }
        return chosenFile;
    }
//    public static WebElement objectsFilesListMethod(List<WebElement> list) {
////        String locator = "//a[@data-action='" + string + "']";
//        String locator = "//a[.='" + string + "']";
//        WebElement leftSideMenu = Driver.getDriver().findElement(By.xpath(locator));
//        return leftSideMenu;
//    }
}



