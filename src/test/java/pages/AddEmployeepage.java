package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeepage {
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement PIM;
    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement Add;
    @FindBy(name = "firstName")
    private WebElement First;
    @FindBy(name = "middleName")
    private WebElement Middle;
    @FindBy(name = "lastName")
    private WebElement Last;
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement Save;

    public AddEmployeepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void menupim()
    {
        PIM.click();
    }
    public void menuadd()
    {
        Add.click();
    }
    public void setFirst()
    {
        First.sendKeys("tom");
    }
    public void setMiddle(String md)
    {

        Middle.sendKeys(md);
    }
    public void setLast()
    {
       Last.sendKeys("harry");
    }
    public void setSave()
    {
        Save.click();
    }
    public void employeeDetials(String f, String m, String l)
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(First));
        First.sendKeys(f);
        wait.until(ExpectedConditions.visibilityOf(Middle));
        Middle.sendKeys(m);
        wait.until(ExpectedConditions.visibilityOf(Last));
        Last.sendKeys(l);
    }
}
