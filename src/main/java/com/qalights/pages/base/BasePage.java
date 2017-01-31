package com.qalights.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.Sleeper.SYSTEM_SLEEPER;

/**
 * Created by brit on 1/15/17.
 */
public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isPageLoaded();

    public void waitFor(Duration duration) {
        try {
            SYSTEM_SLEEPER.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitFor(long msec) {
        waitFor(new Duration(msec, TimeUnit.MILLISECONDS));
    }



}
