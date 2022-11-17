package com.cydeo.trycloud13.step_definitions;

import com.cydeo.trycloud13.pages.TalkPage;
import com.cydeo.trycloud13.utilities.BrowserUtils;
import com.cydeo.trycloud13.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SendMessage_StepDef {

    TalkPage talkPage = new TalkPage();
    String message = "Some Message";

    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {

        int numOfUsers = talkPage.userList.size();
        int randNum = new Faker().number().numberBetween(1, numOfUsers - 1);
        String randUser = talkPage.userList.get(randNum).getText();
        System.out.println("randUser = " + randUser);

        talkPage.userList.get(randNum).click();

    }

    @When("user write a message")
    public void user_write_a_message() {

        BrowserUtils.waitFor(4);
        talkPage.textBox.sendKeys(message);
    }

    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        BrowserUtils.waitFor(1);
        talkPage.sendMessage.click();
    }

    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {

        BrowserUtils.waitFor(4);

        List<WebElement> messageList = Driver.getDriver()
                .findElements(By.xpath("//div[@class='message__main__text']/div"));
        String actualMess = messageList.get(messageList.size() - 1).getText();

        Assert.assertEquals(actualMess, message);
    }


}
