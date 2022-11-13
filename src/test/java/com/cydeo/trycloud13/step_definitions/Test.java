package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.ConfigurationReader;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Test {

 BasePage  basePage=new BasePage();



 @Given("user on the login page")
 public void userOnTheLoginPage() {
  Driver.getDriver().get(ConfigurationReader.getProperty("url"));
 }

 @When("user use username {string} and passcode “Userpass123\"")
 public void user_use_username_and_passcode_userpass123(String string) {

  BrowserUtils.sleep(2);
 basePage.username.sendKeys(string);

 basePage.passcode.sendKeys("Userpass123");

}
 @When("user click the login button")
 public void user_click_the_login_button() {
  basePage.logIn.click();


 }
 @Then("verify the user should be at the dashboard page")
 public void verify_the_user_should_be_at_the_dashboard_page() {
  Assert.assertTrue(Driver.getDriver().getTitle().contains("dashboard"));

 }
}
