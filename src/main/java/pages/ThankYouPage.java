package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage {

    private WebDriver driver;
    private By successAlert = By.cssSelector("body > main > section > article:nth-child(2) > div > div.col-sm-12.col-md-6.col-md-offset-1.col-lg-7.text > div > h2");
    private By thankYouMessage = By.cssSelector("body > main > section > article.container-fluid.z-article > div > div.col-sm-12.col-md-6.col-md-offset-1.col-lg-7.text > div > h2");

    public ThankYouPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessText(){
        return driver.findElement(successAlert).getText();
    }

    public String getThankYouText(){
        return driver.findElement(thankYouMessage).getText();
    }
}
