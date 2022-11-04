package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.pages.FavoritePage;
import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.ConfigurationReader;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TS_13_5_AddFileToFavorites_StepDef {
    static WebElement chosenFile;
    WebElement elementOfTheeDots;

    WebElement elementAddFavorites;
    String chosenFileText;
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    FilesPage filesPage = new FilesPage();
    FavoritePage favoritePage = new FavoritePage();
    Actions actions = new Actions(Driver.getDriver());


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.inputUser.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.logInBtn.click();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        BasePage.chooseTheMenu(string);
    }

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {

        chosenFileText = FilesPage.actionIconsListMethod().getText();
        System.out.println("chosenFileText = " + chosenFileText);
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        elementAddFavorites = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        System.out.println("element = " + elementAddFavorites.getText());
        if (elementAddFavorites.getText().equalsIgnoreCase("Remove from favorites")) {
            elementAddFavorites.click();
            the_user_clicks_action_icon_from_any_file_on_the_page();
            BrowserUtils.sleep(3);
        } else if (elementAddFavorites.getText().equals("Add to favorites")){
            BrowserUtils.sleep(3);
            elementAddFavorites.click();
        }
        BrowserUtils.sleep(3);
    }


    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        BrowserUtils.sleep(3);
        FilesPage.leftSideMenu(string).click();

    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.sleep(3);
        String getText = "";
        for (WebElement each : favoritePage.favoritesFiles) {
            System.out.println("each.getText() = " + each.getText());
            if (each.getText().equalsIgnoreCase(chosenFileText)) {
                System.out.println("chosenFile matched text = " + chosenFileText);
                getText = each.getText();
                System.out.println("getText = " + getText);
            }
        }
        Assert.assertEquals(chosenFileText, getText);
    }
}
