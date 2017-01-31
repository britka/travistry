package com.qalights.tests;

import com.github.agomezmoron.testng.listener.SeleniumScreenshotOnFailureListener;
import com.qalights.driver.DriverFactory;
import com.qalights.driver.WebDriverType;
import com.qalights.pages.site.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

/**
 * Created by sbryt on 1/17/2017.
 */
@Listeners({SeleniumScreenshotOnFailureListener.class})
public class BaseTest {
    public static final String BASE_URL = "http://v3.qalight.com.ua";
    public static WebDriver driver = null;
    LoginPage loginPage = null;

    @BeforeSuite(alwaysRun = true)
    public void beforeAllTests() {
        driver = DriverFactory.initDriver(WebDriverType.FIREFOX);
        goToUrl(BASE_URL);
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    @AfterSuite(alwaysRun = true)
    public void afterAllTests() {
        if (driver != null) {
            driver.quit();
        }
    }


}
