package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.DashboardPage;
import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DashboardStepDefs {
    LoginPage loginPage = new LoginPage();

    @When("user  log in with valid credentials")
    public void user_log_in_with_valid_credentials() {
        loginPage.login();
    }

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModuleNames) {
       List<String> actualModuleNames = new DashboardPage().getModulesText();
      Assert.assertEquals(expectedModuleNames,actualModuleNames);

        Assert.assertEquals(expectedModuleNames, BrowserUtils.getElementsText(new DashboardPage().modules));

    }
}