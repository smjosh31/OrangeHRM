package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ValidateDasbboardTest extends BaseTest {

    @Test
    public void validateDashboard() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        Thread.sleep(1000);
        login.verifyLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Thread.sleep(5000);
        String dashboardUrl = driver.getCurrentUrl();
        assertTrue(dashboardUrl.contains("dashboard"), "Login failed.");
        DashboardPage da = new DashboardPage(driver);
        Thread.sleep(5000);
        da.validateAndClickQuickLaunchTiles();


    }



}
