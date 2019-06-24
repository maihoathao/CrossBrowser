/*
@Athor: HoiNT
@Date : Jun 21 2019
 */
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElementsFb {
    WebDriver driver;
    WebElement email = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("pass"));


}

