package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickContact(){
        clickLink("contact");
        return new ContactPage(driver);
    }

    public JobsPage clickJobs(){
        clickLink("jobs");
        return new JobsPage(driver);
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
