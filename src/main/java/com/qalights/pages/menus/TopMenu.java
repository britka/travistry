package com.qalights.pages.menus;

import com.qalights.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brit on 1/17/17.
 */
public class TopMenu extends BasePage {
    @FindBy(css = ".sidebar-toggle")
    private WebElement hideShowMenuLink;

    @FindBy(css = ".dropdown-toggle")
    private WebElement userMenuButton;

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnHideShowMenuLink() {
        hideShowMenuLink.click();
        waitFor(2000);
    }

    public UserMenuPage openUserMenu(){
        userMenuButton.click();
        return new UserMenuPage(driver);
    }


    public boolean isPageLoaded() {
        return false;
    }
}
