//Create Methods to call the jobs page, then fill out the form. send the information and finally validate the information was sent correctly.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsPage {

    private WebDriver driver;
    private By yourNameField = By.cssSelector("#name");
    private By yourEmailField = By.id("email");
    private By mobilePhoneNumberField = By.id("mobile");
    private By portfolioLinkField = By.id("portfolio");
    private By goodAtTextArea = By.id("description");
    private By sendButton = By.cssSelector("#contact-form > div:nth-child(10) > button");

    public JobsPage(WebDriver driver){ this.driver = driver; }

    public void setYourName(String yourName){
        driver.findElement(yourNameField).sendKeys(yourName);
    }
    public void setYourEmail(String yourEmail){
        driver.findElement(yourEmailField).sendKeys(yourEmail);
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber){
        driver.findElement(mobilePhoneNumberField).sendKeys(mobilePhoneNumber);
    }
    public void setPortfolioLink(String portfolioLink){
        driver.findElement(portfolioLinkField).sendKeys(portfolioLink);
    }
    public void setGoodAtText(String goodAtText){
        driver.findElement(goodAtTextArea).sendKeys(goodAtText);
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
