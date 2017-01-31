package com.qalights.pages.site;

import org.openqa.selenium.WebDriver;

/**
 * Created by brit on 1/15/17.
 */
public class LandingPage extends SiteBasicPage {

    public LandingPage(WebDriver driver) {
        super(driver);

    }

    public boolean isSideBarVisible() {
        return sideMenu.isPageLoaded();
    }

    public LandingPage hideMenu() {
        topMenu.clickOnHideShowMenuLink();
        return new LandingPage(driver);
    }

    public LandingPage showMenu() {
        topMenu.clickOnHideShowMenuLink();
        return new LandingPage(driver);
    }



    public boolean isPageLoaded() {
        return true;
    }
}
