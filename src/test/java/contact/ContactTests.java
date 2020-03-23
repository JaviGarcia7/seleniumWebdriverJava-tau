package contact;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.ThankYouPage;

import java.awt.*;

import static org.testng.Assert.*;

public class ContactTests extends BaseTest {

    @Test
    public void testSuccessfulContactInfo(){
       ContactPage contactPage = homePage.clickContact();
       contactPage.setName("This is an Automation Test on Contact Page");
       contactPage.setEmail("test.qa@mailinator.com");
       contactPage.setMessage("Nam adipiscing. In dui magna, posuere eget, vestibulum et, tempor auctor, justo.");
       contactPage.setDataProtection();
       ThankYouPage thankYouPage = contactPage.clickSendButton();
       try {
            Thread.sleep(3000);
       } catch (InterruptedException e) {
            e.printStackTrace();
       }
       assertTrue(thankYouPage.getSuccessText().contains("thank you"),
               "Successful text is incorrect");
    }
}
