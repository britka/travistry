package com.qalights.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by brit on 1/15/17.
 */
public class DriverFactory {
    static String os = System.getProperty("os.name");

    public static WebDriver initDriver(WebDriverType type) {
        switch (type) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "geckodriver");
         //       System.setProperty("webdriver.gecko.driver", DriverFactory.class.getClassLoader().getResource(getDriverDirectoryByOsName(type)).getFile());
                return new FirefoxDriver();
              //  DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
              //  desiredCapabilities.setCapability(FirefoxDriver.BINARY,"/usr/bin/firefox");

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "chromedriver");
               // System.setProperty("webdriver.chrome.bin", "/usr/bin/chromium-browser");
                //DriverFactory.class.getClassLoader().getResource(getDriverDirectoryByOsName(type)).getFile());
                return new ChromeDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", DriverFactory.class.getClassLoader().getResource(getDriverDirectoryByOsName(type)).getFile());
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                return new InternetExplorerDriver(cap);
            case EDGE:
                System.setProperty("webdriver.edge.driver", DriverFactory.class.getClassLoader().getResource(getDriverDirectoryByOsName(type)).getFile());
                return new EdgeDriver();
            case CHROME_REMOTE:
              //  System.setProperty("webdriver.chrome.driver", "/home/brit/chromedriver");
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                try {
                    return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }


    private static String getDriverDirectoryByOsName(WebDriverType webDriverType) {
        String os = System.getProperty("os.name").toLowerCase();
        String driverFileName = getDriverFileName(webDriverType);
        if (os.contains("win")) {
            return "drivers/win/" + driverFileName + ".exe";
        } else if (os.contains("nix") || os.contains("nux")
                || os.contains("aix")) {
            return "drivers/linux/" + driverFileName;
        } else if (os.contains("mac")) {
            return "driver/mac/" + driverFileName;
        }
        return null;
    }

    private static String getDriverFileName(WebDriverType webDriverType) {
        switch (webDriverType) {
            case CHROME:
                return "chromedriver";
            case FIREFOX:
                return "geckodriver";
            case IE:
                return "IEDriverServer";
            case EDGE:
                return "MicrosoftWebDriver";
        }
        return null;
    }

}
