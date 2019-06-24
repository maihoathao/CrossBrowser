import base.SetUp;
import base.SetupTestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FacebookLogin {
    public static RemoteWebDriver driver;
    public static String urlTest = "https://www.facebook.com";

    public static final String email = "*******";
    public static final String pass = "*******";

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException{
        System.out.println("----Start-----");
        driver = SetupTestDriver.getDriver(browser);
    }

    @Test
    public void loginFb() throws MalformedURLException{
        try {
            driver.navigate().to(urlTest);
            System.out.println("Login to facebook");
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("pass")).sendKeys(pass);
            driver.findElement(By.id("u_0_a")).click();
            Thread.sleep(1000);
            System.out.println("login successful");
        }catch (Exception e){
            System.out.println(e);
        }


    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
