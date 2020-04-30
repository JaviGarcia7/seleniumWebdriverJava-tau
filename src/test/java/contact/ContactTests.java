package contact;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.ThankYouPage;

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
       assertTrue(thankYouPage.getSuccessText().contains("thank you"),
               "Successful text is incorrect");
    }
}
