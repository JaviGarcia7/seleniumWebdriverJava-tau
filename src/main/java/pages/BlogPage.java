//Create Methods to call the blog page, then scroll down and click on the contact us button and finally click on the linkedln social button

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {

    private WebDriver driver;
    private By inputLink = By.className("z-mainlink");
    private By contactUsBtn = By.cssSelector("body > main > article > div > div > p > a");
    private By linkedinBtn = By.cssSelector("body > main > section > article.container-fluid.z-social.z-article > div > div > ul > li:nth-child(4) > a");

    public BlogPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(){
        driver.findElement(inputLink).click();
    }

    public void scrollToButton(){
        WebElement buttonElement = driver.findElement(contactUsBtn);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, buttonElement);

        driver.findElement(contactUsBtn).click();
    }

    public void clickLinkedinBtn(){
        WebElement buttonElement = driver.findElement(linkedinBtn);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, buttonElement);

        driver.findElement(linkedinBtn).click();
    }
}
