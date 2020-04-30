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
        System.out.println(driver.getTitle());
        return new ContactPage(driver);
    }

    public JobsPage clickJobs(){
        clickLink("jobs");
        System.out.println(driver.getTitle());
        return new JobsPage(driver);
    }

    public WorkPage clickClients(){
        clickLink("work");
        System.out.println(driver.getTitle());
        return new WorkPage(driver);
    }

    public EmailSuscriptionPage clickBlog(){
        clickLink("blog");
        System.out.println(driver.getTitle());
        return new EmailSuscriptionPage(driver);
    }

    public BlogPage goToBlog(){
        clickLink("blog");
        System.out.println(driver.getTitle());
        return new BlogPage(driver);
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
