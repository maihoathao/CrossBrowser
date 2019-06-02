import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class MyTest {
    RemoteWebDriver chromeDriver, firefoxDriver;
    String baseUrl, nodeUrl;

    @BeforeTest
    public void setUp() throws MalformedURLException{
        baseUrl = "https://www.google.com";
        nodeUrl = "http://localhost:4444/wd/hub";
        Capabilities chromeCap = DesiredCapabilities.chrome();
        Capabilities firefoxCap = DesiredCapabilities.firefox();
        chromeDriver = new RemoteWebDriver(new URL(nodeUrl),chromeCap);
        firefoxDriver = new RemoteWebDriver(new URL(nodeUrl),firefoxCap);
    }

    @AfterTest
    public void afterTest(){
        chromeDriver.quit();
        firefoxDriver.quit();
    }
     @Test
     public void myTest(){
         // run against chrome
        chromeDriver.get(baseUrl);
        System.out.println("Chrome search:" + chromeDriver.getTitle());

         // run against firefox
         firefoxDriver.get(baseUrl);
         System.out.println("Firefox search:" + firefoxDriver.getTitle());
     }
}
