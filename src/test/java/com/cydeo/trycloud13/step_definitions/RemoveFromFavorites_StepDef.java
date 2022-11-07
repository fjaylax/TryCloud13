package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class RemoveFromFavorites_StepDef {

    FilesPage filesPage = new FilesPage();
    String removedFileName = "";


    @Given("user use username {string} and passcode {string} and login")
    public void userUseUsernameAndPasscodeAndLogin(String username, String password) {
        new LoginPage().userName.sendKeys(username);
        new LoginPage().password.sendKeys(password + Keys.ENTER);

    }


    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String moduleName) {

        BrowserUtils.waitFor(2);
        BasePage.chooseTheMenu(moduleName);
    }


    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {

        String fileName;
        boolean isFavor;
        WebElement threeDots;
        int numFavor = 0;

        for (int i = 0; i < filesPage.listOfFilesNames.size(); i++) {

            isFavor = filesPage.listOfFavorites.get(i).getAttribute("class").equalsIgnoreCase("favorite-mark permanent");
            if (isFavor)
                numFavor ++;
        }

        int random = (int) (Math.random() * numFavor);

        removedFileName = filesPage.listOfFilesNames.get(random).getText();
        System.out.println(removedFileName);

        //div[@class='fileActionsMenu popovermenu bubble open menu']
        filesPage.clickableDots.get(random).click();

    }


    @When("user choose the {string} option")
    public void user_choose_the_option(String optionToClick) {

        List<WebElement> dropMenu = Driver.getDriver().findElements(By.xpath("//div[@class='fileActionsMenu popovermenu bubble open menu']/ul/li"));

        WebElement clickable = null;
        for (WebElement each : dropMenu) {
//            System.out.println(each.getText());
            if (each.getText().equalsIgnoreCase(optionToClick)) {
                clickable = each;
            }
        }
        clickable.click();
    }


    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String leftModuleOption) {

        for (WebElement each : filesPage.leftMenuModules) {
            if (each.getText().equalsIgnoreCase(leftModuleOption)) {
                each.click();
            }
        }
        BrowserUtils.waitFor(2);
    }


    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        for (WebElement each : filesPage.favoriteFileNames) {
            if (each.getAttribute("data-file").equalsIgnoreCase(removedFileName)) {
                Assert.fail("File has not been deleted");
            }
        }
    }


}
