//Create Methods to call the contact page, then fill out the form. send the information and finally validate the information was sent correctly.

package pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;


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

    //@When("The user enters the Mandatory Information")
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

    //@Then("The user clicks on the Send Button")
    public ThankYouPage clickSendButton(){
        driver.findElement(sendButton).click();
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(sendButton)));
        return new ThankYouPage(driver);
    }
}
