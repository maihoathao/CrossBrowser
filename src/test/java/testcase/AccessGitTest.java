/*
Execute test Github demo
@author: Hoi
Date: Jun 25 19
 */
package testcase;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import pages.GithubPages;
import utils.SetupUtil;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.ExcelUtil;

import java.net.MalformedURLException;

public class AccessGitTest {
    public static RemoteWebDriver driver;
    public static XSSFSheet excelSheet;
    public static XSSFCell cell;

    @BeforeClass(alwaysRun = true)

    // Call test driver of Grid with browsers setting on testng
    @Parameters({"browser","nodeUrl"})
    public void setUp(String browser, String nodeUrl) throws MalformedURLException{
        System.out.println("----START-----");
        driver = SetupUtil.getDriver(browser,nodeUrl);
    }

    // test login to facebook
    @Test
    public void loginGithub() throws MalformedURLException{
        try {
            // Call the method to read data from excel file.
            excelSheet = ExcelUtil.readExcel("/Users/maihoathao/Projects/CrossBrowser/src/main/resources/testdata.xlsx","login");
            // Get data from excel file
            String url = excelSheet.getRow(1).getCell(0).getStringCellValue();
            String email = excelSheet.getRow(1).getCell(1).getStringCellValue();
            String pass = excelSheet.getRow(1).getCell(2).getStringCellValue();
            // Execute login
            driver.navigate().to(url);
            System.out.println("Login to: " + url);
            driver.findElement(GithubPages.email).sendKeys(email);
            System.out.println("Email is: " + email);
            driver.findElement(GithubPages.password).sendKeys(pass);
            System.out.println("Password is: " + pass);
            driver.findElement(GithubPages.btnLogin).click();
            SetupUtil.explicitlyWait(driver, GithubPages.lnHome);
            if (driver.findElement(GithubPages.lnHome).isEnabled()){
                System.out.println("---> login successful");
            }
            else {
                System.out.println("---> Login fail");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


    // Execute search repo on Github with data get from excel file
    @Test
    public void searchRepo() throws MalformedURLException{
        try{
            excelSheet = ExcelUtil.readExcel("/Users/maihoathao/Projects/CrossBrowser/src/main/resources/testdata.xlsx","searchrepository");
            String searchrepotext = excelSheet.getRow(1).getCell(1).getStringCellValue();
            System.out.println(searchrepotext);
            driver.findElement(GithubPages.searchRepo).sendKeys(searchrepotext);
            SetupUtil.explicitlyWait(driver,GithubPages.SearchRepoResult);
            if(driver.findElement(GithubPages.SearchRepoResult).isEnabled()){
                System.out.println("---> Search Report Okie");
            }
            else {
                System.out.println("---> Search report is NG");
            }
            driver.findElement(GithubPages.SearchRepoResult).click();
            String verifyRepo = driver.findElement(GithubPages.viewRepo).getText();
            System.out.println(verifyRepo);
            if (verifyRepo.equals(searchrepotext)){
                System.out.println("Repo is valid");
            }
            else {
                System.out.println("Repo is invalid");
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
