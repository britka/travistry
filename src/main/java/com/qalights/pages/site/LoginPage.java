package com.qalights.pages.site;

import com.qalights.User;
import com.qalights.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by brit on 1/15/17.
 */

/**
 * Class that represents login page
 */
public class LoginPage extends BasePage {
    @FindBy(name = "_username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//form//button")
    WebElement submitBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeName(String name) {
        userNameInput.clear();
        userNameInput.sendKeys(name);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }


    public <T> T login(String name, String password, Class<T> tClass) {
        typeCredsAndSubmit(name, password);
        waitFor(1500);
        try {
            return tClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T login(User user, Class<T> tClass) {
        return login(user.getUserLogin(), user.getUserPassword(), tClass);
    }


    private void typeCredsAndSubmit(String name, String pass) {
        typeName(name).typePassword(pass).passwordInput.submit();
    }

    public boolean isPageLoaded() {
        return submitBtn.isDisplayed()
                && userNameInput.isDisplayed()
                && passwordInput.isDisplayed();
    }
}
