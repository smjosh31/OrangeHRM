package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import java.util.List;

;

public class DashboardPage {
    private WebDriver driver;
    private By quicklaunchTiles = By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']/div");


    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }
public void validateAndClickQuickLaunchTiles() throws InterruptedException {

String[] expectedLinks = {
        ConfigReader.getProperty("expectedLink1").trim(),
//        ConfigReader.getProperty("expectedLink2").trim(),
//        ConfigReader.getProperty("expectedLink3").trim(),
//        ConfigReader.getProperty("expectedLink4").trim(),
//        ConfigReader.getProperty("expectedLink5").trim(),
//        ConfigReader.getProperty("expectedLink6").trim()

};
    SoftAssert softAssert = new SoftAssert();

    for (int i = 0; i < expectedLinks.length; i++)
    {
        List<WebElement> tiles = driver.findElements(quicklaunchTiles);
        WebElement tile =tiles.get(i);
        String actual = tile.getText().trim();
        String expected = expectedLinks[i];
        softAssert.assertEquals(actual, expected, " Mismatch at tile index " + i);
        System.out.println("🔍 Comparing index " + i + ": Actual = " + actual + " | Expected = " + expected);
        //tile.click();
        Thread.sleep(3000);
        //driver.navigate().back();
        if (actual.equalsIgnoreCase(expected)) {
            tile.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }
    softAssert.assertAll();

    }
{





    }
}

