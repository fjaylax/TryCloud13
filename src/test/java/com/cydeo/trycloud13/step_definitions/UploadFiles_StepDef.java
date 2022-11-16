package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.FilesPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.ConfigurationReader;
import com.cydeo.trycloud13.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFiles_StepDef {

    FilesPage filesPage = new FilesPage();
    String fileName = ConfigurationReader.getProperty("filename");
    String fileExt = ConfigurationReader.getProperty("fileext");

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.buttonAddNewFile.click();
    }

    @When("users uploads file with the “upload file” option")
    public void users_uploads_file_with_the_upload_file_option() {
//        WebElement uploadFileBtn = Driver.getDriver().findElement(
//                By.xpath("//label[@class='menuitem']"));

          BrowserUtils.waitFor(2);

          WebElement uploadFileBtn = Driver.getDriver().findElement(
                By.xpath("//input[@type='file']"));
          uploadFileBtn.sendKeys(ConfigurationReader.getProperty("failpath")+ fileName + fileExt);

    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOf(filesPage.progressBar));

        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitFor(2);


        boolean isFileFound = false;
        for (WebElement eachFileName : filesPage.listOfFilesNames) {
            String fileNameNow = eachFileName.getText();
            System.out.println(fileNameNow);
            if (fileNameNow.equals(fileName)) {
                isFileFound = true;
            }
        }
        Assert.assertTrue(isFileFound);

        for (WebElement eachFileName : filesPage.listOfFilesNames) {
//            System.out.println(eachFileName.getText());
            if (eachFileName.getText().equals(fileName)) {

                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(eachFileName).contextClick().perform();

                BrowserUtils.waitFor(1);
                Driver.getDriver().findElement(By.xpath("//div[@id='rightClickMenu']//a[@class='menu-option option-delete']")).click();
            }
        }
    }

}
