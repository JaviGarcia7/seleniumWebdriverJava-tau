package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ContactPage {

    private WebDriver driver;
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By messageAreaBox = By.id("message");
    private By dataProtectionCheckBox = By.id("data-protection");
    private By sendButton = By.cssSelector("#contact-form > div:nth-child(9) > button");


    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){ driver.findElement(nameField).sendKeys(name); }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setMessage(String message){
        driver.findElement(messageAreaBox).sendKeys(message);
    }
    public void setDataProtection(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(dataProtectionCheckBox);
        actions.moveToElement(element).click().build().perform();
    }
    public ThankYouPage clickSendButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(sendButton).click();
        return new ThankYouPage(driver);
    }
}
