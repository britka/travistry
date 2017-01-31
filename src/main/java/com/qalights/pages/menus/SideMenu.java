package com.qalights.pages.menus;

import com.qalights.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by brit on 1/17/17.
 */
public class SideMenu extends BasePage {

    @FindBy(css = "#report > a > span")
    private WebElement reportsItem;

    @FindBy(css = "#deal > a > span")
    private WebElement dealsItem;

    @FindBy(css = "#installation > a > span")
    private WebElement instalationItem;

    @FindBy(css = "#service_apparat > a")
    private WebElement serviceItem;

    @FindBy(css = "#deal_type > a")
    private WebElement dealTypesItem;

    @FindBy(css = "#prov_cus > a")
    private WebElement contrAgentsItem;

    @FindBy(css = "#spares > a")
    private WebElement sparesItem;

    @FindBy(css = "#spareType > a")
    private WebElement spareTypesItem;

    @FindBy(css = "#workers > a")
    private WebElement workersItem;

    @FindBy(css = "#apparat > a")
    private WebElement apparatItem;

    @FindBy(css = "#dictionary > a > span")
    private WebElement dictionaryItem;

    @FindBy(css = "#dashboard > a > i")
    private WebElement dashboardItem;

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return dashboardItem.isDisplayed()
                && dictionaryItem.isDisplayed()
                && reportsItem.isDisplayed();
    }


}
