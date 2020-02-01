/*
Get elements of page
@Athor: HoiNT
@Date : Jun 21 2019
 */
package pages;

import org.openqa.selenium.By;

public class GithubPages {
    // Get element of Login page
     public static final By email = By.xpath("//*[@id=\"login_field\"]");
     public static final By password = By.xpath("//*[@id=\"password\"]");
     public  static final By btnLogin = By.xpath("//*[@id=\"login\"]/form/div[3]/input[8]");
     public static final By lnHome = By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/h2");

//   // Get element of Post text function of FB
//    public static final By clickToPost = By.id("js_g");
//    public static final By editContent = By.id("js_g");
//    public static final By click = By.xpath("//span[contains(.,'Post')]");
//    public static final By textposted = By.cssSelector("#js_no p");

  // Get element for search repo
    public static final By searchRepo = By.xpath("//*[@id=\"dashboard-repos-filter-left\"]");
    public static final By SearchRepoResult = By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/ul[1]/li[1]/div/a/span[2]");
    public static final By viewRepo = By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/div/div/h1/strong/a");

}
