package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://zemogadev.zemoga.com");
        driver.manage().window().maximize();
/*        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,250)");*/

        homePage = new HomePage(driver);

/*      driver.manage().window().setSize(new Dimension(1280, 812));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("blog"));
        inputsLink.click();

        WebElement inputsLink2 = driver.findElement(By.className("z-mainlink"));
        inputsLink2.click();

        System.out.println(driver.getTitle());*/
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

/*    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }*/
}
