package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.LoginPage;
import com.cydeo.trycloud13.utilities.ConfigurationReader;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cydeo.trycloud13.utilities.BrowserUtils.clickElement;
import static com.cydeo.trycloud13.utilities.BrowserUtils.verifyTitle;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env_try"));
    }
    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {


        loginPage.login(username,password);

    }
    @When("user click login button")
    public void user_click_login_button() {
        clickElement(loginPage.btn_login);
    }
    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
        verifyTitle("Dashboard");
    }

}
