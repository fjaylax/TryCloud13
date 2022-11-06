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

import java.util.List;

public class TS_13_5_AddFileToFavorites_StepDef {
    String chosenFileText;
    LoginPage loginPage = new LoginPage();
    FavoritePage favoritePage = new FavoritePage();
    FilesPage filesPage = new FilesPage();


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
        Faker faker = new Faker();
        int num = faker.number().numberBetween(1, filesPage.actionIconsList.size());
        WebElement elementOfTheeDots;
        for (int i = 1; i <= filesPage.actionIconsList.size(); i++) {
            if (i == num) {
                chosenFileText = filesPage.objectsFilesList.get(i).getText();
                elementOfTheeDots = filesPage.actionIconsList.get(i);
                elementOfTheeDots.click();
            }
        }
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        if (filesPage.favoriteOptionFromThreeDots.getText().equals(string)){
            filesPage.favoriteOptionFromThreeDots.click();
        }else{
            filesPage.favoriteOptionFromThreeDots.click();
            chosenFileText = FilesPage.user_choose_the_option();
            }
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        FilesPage.leftSideMenu(string).click();
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        String getText = "";
        for (WebElement each : favoritePage.favoritesFiles) {
            if (each.getText().equalsIgnoreCase(chosenFileText)) {
                getText = each.getText();
            }
        }
        Assert.assertEquals(chosenFileText, getText);
    }
}
