package com.backmarket.step_definitions;

import com.backmarket.pages.HelloPages;
import com.backmarket.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
public class HelloStepsDef {

    HelloPages homePage = new HelloPages();

    @Given("the user lands on home page")
    public void the_user_lands_on_home_page() {

        // This steps handle with @BeforeMethod
    }

    @When("the user scrolls down to the bottom of the webpage")
    public void the_user_scrolls_down_to_the_bottom_of_the_webpage() {

        homePage.acceptCookies.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("arguments[0].scrollIntoView(true);",homePage.theRockLink);
    }

    @And("the user clicks on {string} link")
    public void the_user_clicks_on_link(String linkName) {

        homePage.clickOnTheLink(linkName);
    }

    @Then("the user navigates {string}")
    public void the_user_navigates(String expectedUrl) {

        homePage.switchToWindow();
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("The WebPage does not correct",expectedUrl,actualUrl);

    }

}
