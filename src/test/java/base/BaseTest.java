package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTest {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://zemoga.com/");
        driver.manage().window().setSize(new Dimension(1280, 812));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("blog"));
        inputsLink.click();

        WebElement inputsLink2 = driver.findElement(By.id("106"));
        inputsLink2.click();

        System.out.println(driver.getTitle());
        //driver.quit();
    }

    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
