package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.BasePage;
import com.cydeo.trycloud13.pages.Us4Page;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Base64;


public class Us4_StepDef {

    Us4Page us4Page = new Us4Page();

    @Given("user use {string} and {string}")
    public void user_use_and(String string, String string2) {

    }

    @When("the user clicks the {string} module and on files")
    public void the_user_clicks_the_module_and_on_files(String string) {
//        us4Page.filesBtn.click();
        BasePage.chooseTheMenu(string);

   }
    @Then("verify page title is {string}")
    public void verify_the_page_title_is(String string) {
        BrowserUtils.sleep(1);
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        BrowserUtils.sleep(2);
        us4Page.selectAll.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
            BrowserUtils.sleep(2);
            Assert.assertTrue(BrowserUtils.isAllSelected(us4Page.checkFileButtons));
        }



}
