/*
Get elements of page
@Athor: HoiNT
@Date : Jun 21 2019
 */
package pages;

import org.openqa.selenium.By;

public class LoginPage {
    // Get element of Login page
     public static final By email = By.id("email");
     public static final By password = By.id("pass");
     public static final By btnLogin = By.id("u_0_a");

   // Get element of Post text function
//    public static final By clickPostText = By.id("js_d");
//    public static final By editContent = By.cssSelector(".notranslate");
//    public static final By click = By.cssSelector(".\\_1mf7");
    public static final By clickPostText = By.id("js_g");
    public static final By editContent = By.id("js_g");
    public static final By click = By.xpath("//span[contains(.,'Post')]");
    public static final By textposted = By.cssSelector("#js_no p");

}
