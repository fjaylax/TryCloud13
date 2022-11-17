package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.pages.FavoritePage;
import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;



public class TS_13_5_AddFileToFavorites_StepDef {

    static WebElement chosenFile;
    static String chosenFileText;


    FavoritePage favoritePage = new FavoritePage();
    FilesPage filesPage = new FilesPage();

    /*
    Login to the http://qa2.trycloud.net/.
     */
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        loginPage.inputUser.sendKeys(ConfigurationReader.getProperty("username"));
//        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
//        loginPage.logInBtn.click();

    }

    /*
    Use method chooseTheMenu(string) from the BasePage, to choose option on top of dashboard in the home page.
     */

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        BasePage.chooseTheMenu(string);
    }

    /*
    By the Faker (faker.number().numberBetween(1, filesPage.actionIconsList.size()) - random number from List of three dots menu elements) choose a file to click and comparing with List of file names.
     */

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        Faker faker = new Faker();
        int num = faker.number().numberBetween(1, filesPage.actionIconsList.size());
        WebElement elementOfTheeDots;
        for (int i = 1; i <= filesPage.actionIconsList.size(); i++) {
            if (i == num) {
                chosenFileText = filesPage.objectsFilesList.get(i).getText();
//                System.out.println("chosenFileText from StepDef = " + chosenFileText);
                elementOfTheeDots = filesPage.actionIconsList.get(i);
                elementOfTheeDots.click();
            }
        }
    }

    /*
    Check what option is displayed after click three dots element. If option is equals with a current string -> click this option.
    If element is already added to Favorites, we click element to remove from Favorites, and call method what will repeat previews steps until find an element what doesn't add in Favorites, and add it.
     */
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        System.out.println("filesPage.favoriteOptionFromThreeDots from StepDef = " + filesPage.favoriteOptionFromThreeDots.getText());
        if (filesPage.favoriteOptionFromThreeDots.getText().equals(string)) {
            filesPage.favoriteOptionFromThreeDots.click();
        }
        else {
            filesPage.favoriteOptionFromThreeDots.click();
            chosenFileText = user_choose_the_optionAddFavorite(string);
        }
    }

    /*
    Use a method, what choose required option from the List of webElements on left top side. In this case we click Favorites option.
     */
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        FilesPage.leftSideMenu(string).click();
    }

    /*
    We are comparing chosen file from List of file names with a List of file names on a Favorite, and make Assertion equals.
     */

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        String getText = "";
        for (WebElement each : favoritePage.favoritesFiles) {
            if (each.getText().equalsIgnoreCase(chosenFileText)) {
                getText = each.getText();
            }
        }
        System.out.println("chosenFileText Assertions= " + chosenFileText);
        System.out.println("getText Assertions= " + getText);
        Assert.assertEquals(chosenFileText, getText);
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

    /**
     * Name of file from List of files names what is added to Favorites
     * @return String
     */
    public static String user_choose_the_optionAddFavorite(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        BrowserUtils.sleep(1);
        chosenFileText = actionIconsListMethod().getText();
        System.out.println("chosenFileText from Method = " + chosenFileText);
        String chosen = "";
        WebElement elementAddFavorites = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        System.out.println("elementAddFavorites from Method = " + elementAddFavorites.getText());
        if (!elementAddFavorites.getText().equalsIgnoreCase(elementAddFavorites.getText())) {
            wait.until(ExpectedConditions.elementToBeClickable(elementAddFavorites));
            elementAddFavorites.click();
            return user_choose_the_optionAddFavorite(string);
        } else if (elementAddFavorites.getText().equals(elementAddFavorites.getText())) {
            wait.until(ExpectedConditions.elementToBeClickable(elementAddFavorites));
            elementAddFavorites.click();
            chosen = chosenFileText;
            return chosen;
        }
        return chosen;
    }

}
