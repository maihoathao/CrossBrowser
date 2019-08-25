package testcase;/*
Execute test facebook demo
@author: Hoi
Date: Jun 25 19
 */
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.SetupUtil;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.ExcelUtil;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FacebookTest {
    public static RemoteWebDriver driver;
    public static XSSFSheet excelSheet;
    public static XSSFCell cell;

    @BeforeClass(alwaysRun = true)

    // Call test driver of Grid with browsers seting on testng
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException{
        System.out.println("----START-----");
        driver = SetupUtil.getDriver(browser);
    }

    // test login to facebook
    @Test
    public void loginFb() throws MalformedURLException{
        try {
            // Call the method to read data from excel file.
            excelSheet = ExcelUtil.readExcel("/Users/maihoathao/Projects/CrossBrowser/src/main/resources/testdata.xlsx","login");
            // Get data from excel file
            String url = excelSheet.getRow(1).getCell(0).getStringCellValue();
            String email = excelSheet.getRow(1).getCell(1).getStringCellValue();
            String pass = excelSheet.getRow(1).getCell(2).getStringCellValue();
            // Execute login
            driver.navigate().to(url);
            System.out.println("Login to facebook" + url);
            driver.findElement(LoginPage.email).sendKeys(email);
            System.out.println("email login:"+email);
            driver.findElement(LoginPage.password).sendKeys(pass);
            System.out.println("Password login:" + pass);
            driver.findElement(LoginPage.btnLogin).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("login successful");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void postText() throws MalformedURLException{
        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            excelSheet = ExcelUtil.readExcel("/Users/maihoathao/Projects/CrossBrowser/src/main/resources/testdata.xlsx", "posttext");
            String posttext = excelSheet.getRow(1).getCell(1).getStringCellValue();
            driver.findElement(LoginPage.clickPostText).click();
            driver.findElement(LoginPage.editContent).sendKeys(posttext);
            driver.findElement(LoginPage.click).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(LoginPage.textposted));
            String textcompare = driver.findElement(LoginPage.textposted).getText();
            if(posttext == textcompare){
                System.out.println("Post success: " + textcompare);
            }
            else {
                System.out.println("Post NG");
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterClass
    public void afterTest(){
        driver.quit();
    }

}
