/*
Setup test driver using Selenium Grid to run test browser parallel
@author: Hoi
Date Jun 25 19
 */
package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SetupUtil {
    private static String nodeUrl = "http://localhost:4444/wd/hub";

    public static DesiredCapabilities SetupBrowser(String browserType){
        if ("chrome".equals(browserType)) {
            System.out.println("Opening Chrome");
            return DesiredCapabilities.chrome();
        } else if ("firefox".equals(browserType)) {
            System.out.println("Opening firefox");
            return DesiredCapabilities.firefox();
        } else if ("IE".equals(browserType)) {
            System.out.println("Opening IE");
            return DesiredCapabilities.internetExplorer();
        }
        System.out.println("Browser:" + browserType + "is invalid, Launching default browser is Firefox");
        return DesiredCapabilities.firefox();
    }
    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        return new RemoteWebDriver(new URL(nodeUrl),SetupBrowser(browser));
    }
}
