package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class EmailSuscriptionPage {

    private WebDriver driver;
    private By inputField = By.id("subscribe-email");
    private By summitButton = By.cssSelector("#subscribe-form > div.form-group.z-subscribe-inputs > div > button");

    public EmailSuscriptionPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(inputField).sendKeys(email);
    }

    public ThankYouPage clickSuscribe(){
        driver.findElement(summitButton).click();
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(summitButton)));
        return new ThankYouPage(driver);
    }
}
