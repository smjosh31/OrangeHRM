package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddEmployeepage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Excel;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ValidateAddEmployee extends BaseTest {
    @DataProvider(name = "testData")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"admin","admin123","hari", "om", "bha"},
                {"dgd","dff","rajiv", "banega", "gentle"}
        };
    }


    @Test(dataProvider = "testData")
    public void validateAddEmployee(String uN,String pW,String fN,String mN,String LN) throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        Thread.sleep(1000);
        //  login.verifyLogin(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
//        String UN = Excel.getValue("src/test/resources/ExcelInputdata.xlsx", "Sheet1", 1, 0);
//        String pwd = Excel.getValue("src/test/resources/ExcelInputdata.xlsx", "Sheet1", 1, 1);
        login.verifyLogin(uN, pW);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String dashboardUrl = driver.getCurrentUrl();
        assertTrue(dashboardUrl.contains("dashboard"), "Login failed — dashboard URL not found.");
        AddEmployeepage add = new AddEmployeepage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
        add.menupim();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']")));
        add.menuadd();

        add.employeeDetials(fN,mN,LN);
        //add.employeeDetials("dfgf","sdfd","fdsf");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        add.setFirst();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName")));
        add.setMiddle("dfgdf");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
//        add.setLast();
        add.setSave();


    }
}