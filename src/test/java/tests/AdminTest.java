package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AddEmployeepage;
import pages.LoginPage;
import pages.UserManagementPage;
import utilities.ConfigReader;
import utilities.Excel;
import utilities.base.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

@Test
    public class AdminTest extends BaseTest {
    public void adminTest() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(1000);
        //  login.verifyLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        String UN = Excel.getValue("src/test/resources/ExcelInputdata.xlsx", "Sheet1", 1, 0);
        String pwd = Excel.getValue("src/test/resources/ExcelInputdata.xlsx", "Sheet1", 1, 1);
        login.verifyLogin(UN, pwd);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String dashboardUrl = driver.getCurrentUrl();
        assertTrue(dashboardUrl.contains("dashboard"), "Login failed — dashboard URL not found.");

        UserManagementPage page = new UserManagementPage(driver);

        page.menuadmin();
        page.setusername();
        page.clickDropdownArrow();
        page.selectadmin();

    }
}