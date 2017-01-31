package com.qalights.pages.menus;

import com.qalights.pages.base.BasePage;
import com.qalights.pages.site.UserProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brit on 1/17/17.
 */
public class UserMenuPage extends BasePage {
    @FindBy(css = ".user-header > .img-circle")
    private WebElement userPicture;

    @FindBy(css = ".user-footer > .pull-left > a")
    private WebElement profileButton;

    @FindBy(css = ".user-footer > .pull-right > a")
    public WebElement logoutButton;

    public UserMenuPage(WebDriver driver) {
        super(driver);
    }

    public UserProfilePage toUserProfile(){
        profileButton.click();
        waitFor(1500);
        return new UserProfilePage(driver);
    }


    public boolean isPageLoaded() {
        return false;
    }
}
