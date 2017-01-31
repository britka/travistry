package com.qalights.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brit on 1/24/17.
 */
public class Page404 extends BasePage {

    private final String URL = "http://v3.qalight.com.ua/register.html";

    @FindBy(css = "p > a")
    private WebElement returnToMainPageLink;

    @FindBy(css = "h3")
    private WebElement _404Error;

    public Page404(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return _404Error.isDisplayed()
                && _404Error.getText().contains("404")
                && returnToMainPageLink.isDisplayed()
                && driver.getCurrentUrl().equals(URL);
    }
}