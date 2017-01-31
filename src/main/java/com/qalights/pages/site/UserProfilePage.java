package com.qalights.pages.site;

import com.qalights.models.ProfileUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brit on 1/24/17.
 */
public class UserProfilePage extends SiteBasicPage {


    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[name='delete']")
    private WebElement dnleteButtom;

    @FindBy(css = "button[name='save']")
    private WebElement saveButton;

    @FindBy(id = "userProfileEdit_user_password_password_confirm")
    private WebElement confirmPassField;

    @FindBy(id = "userProfileEdit_user_password_password")
    private WebElement passField;

    @FindBy(id = "userProfileEdit_user_username")
    private WebElement loginField;

    @FindBy(id = "userProfileEdit_user_name")
    private WebElement nickNameField;

    @FindBy(id = "userProfileEdit_user_email")
    private WebElement emailField;

    public UserProfilePage fillForm(ProfileUserModel profileUserModel) {
        fillUserFor(profileUserModel.getDataToFillForm());
        return this;
    }


    private void fillUserFor(HashMap<Map<String, String>, Object> map) {
        for (Map.Entry<Map<String, String>, Object> o : map.entrySet()) {
            By fibdBy = o.getKey().keySet().toArray()[0].equals("id") ?
                    By.id(o.getKey().get("id")) : By.name(o.getKey().get("name"));
            driver.findElement(fibdBy).clear();
            driver.findElement(fibdBy).sendKeys((String) o.getValue());
        }
    }
}
