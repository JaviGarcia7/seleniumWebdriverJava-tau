package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {

    private WebDriver driver;
    private By successAlert = By.className("z-thank-you");

    public ThankYouPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessText(){
       return driver.findElement(successAlert).getText();
    }
}
