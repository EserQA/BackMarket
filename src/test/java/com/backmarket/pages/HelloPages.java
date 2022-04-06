package com.backmarket.pages;

import com.backmarket.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class HelloPages extends BasePage{

    @FindBy(name = "The Rock")
    public WebElement theRockLink;

    @FindBy(xpath = "//span[contains(.,'cool with that')]")
    public WebElement acceptCookies;


    public void clickOnTheLink(String linkName){
        Driver.get().findElement(By.name(linkName)).click();
    }

    public void switchToWindow() {

        String currentWindowHandle = Driver.get().getWindowHandle();
        Set<String> windowHandles = Driver.get().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)){
                Driver.get().switchTo().window(windowHandle);
            }
        }
    }
}
