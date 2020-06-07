package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    protected static EyesManager eyesManager;

    @BeforeClass
    public void setUp() {
        Properties props = System.getProperties();
        try{
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        driver = new EventFiringWebDriver (new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        setCookie();

        eyesManager = new EyesManager(driver, "Zemoga");
    }

    @BeforeMethod
    public void goHome(){
        driver.get("http://zemogadev.zemoga.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        eyesManager.abort();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("zSite", "1234")
                .domain("zemogadev.zemoga.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    public WebDriver getDriver() {
        return driver;
    }
}


    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /*JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,250)");*/

/*      driver.manage().window().setSize(new Dimension(1440, 812));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink = driver.findElement(By.linkText("blog"));
        inputsLink.click();

        WebElement inputsLink2 = driver.findElement(By.className("z-mainlink"));
        inputsLink2.click();

        System.out.println(driver.getTitle());*/

/*    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }*/
