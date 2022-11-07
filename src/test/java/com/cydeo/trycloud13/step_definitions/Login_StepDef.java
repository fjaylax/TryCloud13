package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDef {

    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void userOnTheLoginPage() {

    }

    @Given("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue("Login unsuccessfully", Driver.getDriver().getTitle().contains("Dashboard"));
    }


}
