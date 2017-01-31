package com.qalights.pages.site;

import com.qalights.pages.base.BasePage;
import com.qalights.pages.menus.SideMenu;
import com.qalights.pages.menus.TopMenu;
import org.openqa.selenium.WebDriver;

/**
 * Created by brit on 1/17/17.
 */
public class SiteBasicPage extends BasePage {
    SideMenu sideMenu;
    TopMenu topMenu;


    public SiteBasicPage(WebDriver driver) {
        super(driver);
        sideMenu = new SideMenu(this.driver);
        topMenu = new TopMenu(this.driver);
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public LoginPage logout() {
        topMenu.openUserMenu().logoutButton.click();
        waitFor(1500);
        return new LoginPage(driver);
    }

    public boolean isPageLoaded() {
        return false;
    }
}
