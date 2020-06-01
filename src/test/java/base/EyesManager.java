package base;

import com.applitools.eyes.selenium.Eyes;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class EyesManager {

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    public EyesManager(WebDriver driver, String appName){
        this.driver = driver;
        this.appName = appName;

        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://zemogadev.zemoga.com/about");
        eyes.open(driver, "Zemoga / About",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow();
        eyes.close();
    }

    public void validateElement(By locator){
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://zemogadev.zemoga.com/contact");
        eyes.open(driver, "Zemoga / Contact",
                Thread.currentThread().getStackTrace()[1].getMethodName());
        eyes.checkElement(locator);
        eyes.close();
    }

    public static boolean validatePDF(String filepath) throws IOException, InterruptedException {
        String command = String.format(
                "java -jar resources/ImageTester.jar -k %s -f %s",
                System.getProperty("applitools.api.key"),
                filepath);

        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        String stream = IOUtils.toString(process.getInputStream(), "UTF-8");
        System.out.println(stream);

        if(stream != null && stream.contains("Mismatch")){
            return false;
        }

        return true;
    }

    public void abort(){
        eyes.abortIfNotClosed();
    }
}
