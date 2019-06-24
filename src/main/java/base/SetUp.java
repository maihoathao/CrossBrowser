/*
@author Hoi
Date Jun 17 19
 */
package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SetUp {
    RemoteWebDriver chromeDriver, firefoxDriver;
//    String baseUrl, nodeUrl;

    public static final String nodeUrl = "http://localhost:4444/wd/hub";
    public static final String baseUrl = "https://www.facebook.com";

    public SetUp() throws MalformedURLException {
//        baseUrl = "https://www.google.com";
//        nodeUrl = "http://localhost:4444/wd/hub";
        Capabilities chromeCap = DesiredCapabilities.chrome();
        Capabilities firefoxCap = DesiredCapabilities.firefox();
        chromeDriver = new RemoteWebDriver(new URL(nodeUrl),chromeCap);
        firefoxDriver = new RemoteWebDriver(new URL(nodeUrl),firefoxCap);
    }
    public RemoteWebDriver setChromeDriver(){
        return chromeDriver;
    }
    public RemoteWebDriver setFirefoxDriver(){
        return firefoxDriver;
    }
    public String setUrl(){
        return baseUrl;
    }

}
