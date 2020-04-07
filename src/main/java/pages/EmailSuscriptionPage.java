package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSuscriptionPage {

    private WebDriver driver;
    private By inputLink = By.className("z-mainlink");
    private By inputField = By.id("subscribe-email");
    private By summitButton = By.cssSelector("#subscribe-form > div.form-group.z-subscribe-inputs > div > button");

    public EmailSuscriptionPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(){
        driver.findElement(inputLink).click();
    }

    public void enterEmail(String email){
        driver.findElement(inputField).sendKeys(email);
    }

    public ThankYouPage clickSuscribe(){
        driver.findElement(summitButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ThankYouPage(driver);
    }
}
