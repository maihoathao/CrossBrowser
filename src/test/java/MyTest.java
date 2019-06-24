/*
@author Hoi
Date Jun 17 19
 */
import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class MyTest {
    RemoteWebDriver chromeTest, firefoxTest;
    String urlTest;
    WebDriver driver;

    public static final String email = "maihoathao2004@yahoo.com";
    public static final String pass = "Xanh$&@Ngoc654";

    @BeforeClass(alwaysRun = true)
//    @Parameters({"node","url"})
    @Test
     public void myTest() throws MalformedURLException{

        SetUp setUp = new SetUp();
        urlTest = setUp.setUrl();

        // run against chrome
        chromeTest = setUp.setChromeDriver();
        chromeTest.get(urlTest);
        System.out.println("Chrome: " + chromeTest.getTitle());
//        Assert.assertTrue(chromeTest.getTitle().contentEquals("Google"));

         // run against firefox
        firefoxTest = setUp.setFirefoxDriver();
        firefoxTest.get(urlTest);
        System.out.println("Firefox: " + firefoxTest.getTitle());
//        Assert.assertTrue(firefoxTest.getTitle().contentEquals("Google"));
     }

     @Test
     public void loginFb() throws MalformedURLException{
         driver.findElement(By.id("id")).sendKeys(email);
         driver.findElement(By.id("pass")).sendKeys(pass);
         driver.findElement(By.id("loginbutton")).click();
     }

     @AfterTest
     public void afterTest(){
        chromeTest.quit();
        firefoxTest.quit();
    }
}
