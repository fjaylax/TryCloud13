package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Then;

public class VerifyTalksModuleAccess_StepDef {

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {

        BrowserUtils.verifyTitle(Driver.getDriver(), expectedTitle);

    }
}
