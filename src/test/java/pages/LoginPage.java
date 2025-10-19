package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import java.time.Duration;
import java.time.Instant;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;



    public class LoginPage {
        private WebDriver driver;
        private WebDriverWait wait;
        @FindBy(xpath = "//input[@placeholder='Username']")
        private WebElement unTB;
        @FindBy(xpath = "//input[@placeholder='Password']")
        private WebElement pwTB;
        @FindBy(xpath ="//button[@type='submit']")
        private WebElement lnBTN;


        public LoginPage(WebDriver driver) {
            this.driver =driver;
            PageFactory.initElements(driver, this);
        }

        public void verifyLogin(String username, String Password) {
            unTB.sendKeys(username);
            pwTB.sendKeys(Password);
            lnBTN.click();
        }

    }



