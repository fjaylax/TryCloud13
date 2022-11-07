package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TS_13_10_SeeTheAppStorageUsage {
    FilesPage filesPage = new FilesPage();
    String spaceBeforeUpload;

    /*
    Checking is already test file is uploaded, delete this file.
    Checking current storage space.
     */
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        for (int i = 0; i < filesPage.objectsFilesList.size(); i++) {
            if (filesPage.objectsFilesList.get(i).getText().contains("findElements")) {
                filesPage.actionIconsList.get(i).click();
                FilesPage.popupMenu("Delete file").click();
                Driver.getDriver().navigate().refresh();
            }
        }
        spaceBeforeUpload = filesPage.currentStorageSpace.getText();
    }

    /*
    Uploading the test file.
     */
    @When("user uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() {

        filesPage.uploadFileOption.click();
        BrowserUtils.sleep(1);
        filesPage.uploadFile.sendKeys("C:\\Users\\15717\\Desktop\\Automation\\findElements_checkbox_radioButton.pdf");
        BrowserUtils.sleep(3);
    }

    /*
    Refresh page.
     */
    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);
    }

    /*
    Assert storage space before and after changes.
     */
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        Assert.assertTrue(Double.parseDouble(spaceBeforeUpload.substring(0,3)) < Double.parseDouble(filesPage.currentStorageSpace.getText().substring(0,3)));
    }
}
