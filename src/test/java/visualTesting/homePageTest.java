package visualTesting;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class homePageTest extends BaseTest {

    @Test
    public void visualTestingWindow(){
        eyesManager.validateWindow();
    }

    @Test
    public void visualTestingElement(){
        eyesManager.validateElement(By.cssSelector("body > main > section > article.container-fluid.find-us.z-article"));
    }

}
