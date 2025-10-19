package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserManagementPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath="//span[text()='Admin']")
    private WebElement Admin;
    @FindBy(xpath= "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement username;
    @FindBy(xpath= "//div[contains(@class,'oxd-select-text--after')]")
    private WebElement DropdownArrow;
    @FindBy(xpath="        adminOptionElement.click();\n")
    private WebElement adminOptionElement;
    @FindBy(xpath="(//div[text()='ESS'])[1]")
    private WebElement ESSOption;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void menuadmin()
    {
        wait.until(ExpectedConditions.elementToBeClickable(Admin)).click();
    }
    public void setusername(){
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("Santosh");
    }
    public void clickDropdownArrow(){
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(DropdownArrow));
        DropdownArrow.click();
    }

    public void selectadmin()
    {
        By adminOption = By.xpath("//div[@role='option' and normalize-space()='Admin']");
        WebElement adminOptionElement = wait.until(ExpectedConditions.elementToBeClickable(adminOption));
        adminOptionElement.click();
    }

}
