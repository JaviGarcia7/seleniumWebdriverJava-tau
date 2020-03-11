package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    private WebDriver driver;
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By messageAreaBox = By.id("message");
    private By dataProtectionCheckBox = By.xpath("//*[@id=\"data-protection\"]");
    private By sendButton = By.cssSelector("#contact-form button");


    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setMessage(String message){
        driver.findElement(messageAreaBox).sendKeys(message);
    }
    public void setDataProtection(){
        driver.findElement(dataProtectionCheckBox).click();
    }
    public ThankYouPage clickSendButton(){
        driver.findElement(sendButton).click();
        return new ThankYouPage(driver);
    }
}
