package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.TryCloud_US13_Page;
import com.cydeo.trycloud13.utilities.ConfigurationReader;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TryCloud_US13_StepDefinitions {
      TryCloud_US13_Page tryCloudUs13Page= new TryCloud_US13_Page();
     @Given("user on the dashboard page")
     public void user_on_the_dashboard_page() {
     Driver.getDriver().getTitle().contains("Dashboard");
     }
     @When("the user clicks the contacts module")
     public void the_user_clicks_the_contacts_module() {
     tryCloudUs13Page.contactModule.click();
     }
     @Then("verify the contact names are in the list")
     public void verify_the_contact_names_are_in_the_list() {

        for (WebElement eachName : tryCloudUs13Page.contactList )  {
            System.out.println(eachName.getText());

        }
     }
     @Given("user logs in")
     public void userLogsIn() {
               Driver.getDriver().get("http://qa3.trycloud.net/index.php/login?clear=1");

               tryCloudUs13Page.userNameBtn.sendKeys("User13");

               tryCloudUs13Page.passwordBtn.sendKeys("Userpass123");

               tryCloudUs13Page.loginBtn.click();
          }
     }

