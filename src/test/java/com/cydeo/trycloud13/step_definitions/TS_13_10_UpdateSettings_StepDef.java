package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TS_13_10_UpdateSettings_StepDef {

    FilesPage filesPage = new FilesPage();

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settingButton.click();
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        for (int i = 0; i < filesPage.listOfSettingOptions.size(); i++) {
            filesPage.listOfSettingOptions.get(i).click();
        }
    }
}
