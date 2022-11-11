package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.TryCloud_US2_Page;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TryCloud_US2_StepDefinitions {
    TryCloud_US2_Page tryCloud_page = new TryCloud_US2_Page();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get("http://qa3.trycloud.net/index.php/login?clear=1");
    }

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {
        tryCloud_page.login(username, password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        tryCloud_page.loginBtn.click();
    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String message) {

       Assert.assertTrue("The message failed",tryCloud_page.wrongMessage.isDisplayed());
    }

}