package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Excel;
import utilities.base.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void logintest() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(1000);


        
      //  login.verifyLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
       String UN = Excel.getValue("src/test/resources/ExcelInputdata.xlsx","Sheet1",1,0);
        String pwd = Excel.getValue("src/test/resources/ExcelInputdata.xlsx", "Sheet1", 1, 1);
        int count = Excel.getRowCount("src/test/resources/ExcelInputdata.xlsx","Sheet1");
       System.out.println(count);
        int columns = Excel.getColumnCount("src/test/resources/ExcelInputdata.xlsx","Sheet1",1);
       System.out.println(columns);
        login.verifyLogin(UN,pwd);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String dashboardUrl = driver.getCurrentUrl();
        assertTrue(dashboardUrl.contains("dashboard"), "Login failed — dashboard URL not found.");

    }
   @Test
   public void invlaidlogintest() {
       LoginPage login = new LoginPage(driver);
        String username = ConfigReader.getProperty("invalidusername");
        String password = ConfigReader.getProperty("invalidpassword");
        login.verifyLogin(Excel.getValue("src/test/resources/ExcelInputdata.xlsx","Sheet1",2,0),Excel.getValue("src/test/resources/ExcelInputdata.xlsx","Sheet1",2,1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
       System.out.println(errormsg);
        String Actualerrormsg = errormsg.getText();
        Assert.assertEquals(Actualerrormsg, "Invalid credentials", "Error message not matched for invalid login.");

    }
}
