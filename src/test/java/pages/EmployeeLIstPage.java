package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeLIstPage {
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement PIM;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement EmployeeNamesearch;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
    List <WebElement> EmployeeNameSelect;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement EmployeeId;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    private WebElement EmploymentStatus;

    @FindBy(xpath = "//div[@role='option']")
    private List<WebElement> EmploymentStatusdropdown;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    private WebElement SupervisorNamesearch;

    @FindBy(xpath = "//div[@role='option']")
    List <WebElement> SupervisorNameselect;

   // @FindBy(xpath = "(//div[text()='-- Select --'])[2]")
   // private WebElement JobTitle;

   // @FindBy(xpath = "//div[@role='option']")
  //  private List<WebElement> JobTitledropdown;

    public EmployeeLIstPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AdminPIM() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(PIM)).click();

    }

    public void EmployeeNameSearchtext() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(EmployeeNamesearch)).sendKeys("s");

    }

    public void EmployeeNameSelecttext() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='oxd-autocomplete-option']"), 1));
         EmployeeNameSelect.get(1).click();


    }

    public void EmployeeIdtext() {
        EmployeeId.sendKeys("12345");
    }

    public void EmployeeStatustext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(EmploymentStatus)).click();
        EmploymentStatus.click();
    }

    public void EmployeeStatusdropdowntext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(EmploymentStatus)).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
        System.out.println("Number of options: " + options.size());

        for (WebElement op : options) {

            String actualvalue = op.getText();
                    System.out.println(actualvalue);
            if (actualvalue.equalsIgnoreCase("IT Manager")){
                op.click();
            }

        }
    }
        public void JobTitle ()
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='-- Select --'])[2]"))).click();
        }

        public void JobTitledropdown(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
            System.out.println("Number of options: " + options.size());

            for (WebElement op : options) {

                System.out.println(op.getText());
            }
        }

        public void SupervisorNamesearch(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(SupervisorNamesearch)).sendKeys("a");
        }

        public void SupervisorNameselect(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@role='option']"),1));
            SupervisorNameselect.get(0).click();
        }
    }
