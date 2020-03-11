package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By contactLink = By.linkText("contact");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    public ContactPage clickContact(){
        driver.findElement(contactLink).click();
        return new ContactPage(driver);
    }
}
