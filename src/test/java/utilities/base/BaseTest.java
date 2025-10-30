package utilities.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.ConfigReader;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("WebDriver.chrome.driver", "Drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

    }
  //  @AfterMethod
    public void teardown() throws InterruptedException {
       if(driver!=null)
          driver.quit();
    }
}
