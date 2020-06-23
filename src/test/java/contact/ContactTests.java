package contact;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.ThankYouPage;

import static org.testng.Assert.*;

public class ContactTests extends BaseTest {

    @Test
    public void testSuccessfulContactInfo(){
       ContactPage cPage = contactPage.clickContact();
       cPage.setName("This is an Automation Test on Contact Page");
       cPage.setEmail("test.qa@mailinator.com");
       cPage.setMessage("Nam adipiscing. In dui magna, posuere eget, vestibulum et, tempor auctor, justo.");
       cPage.setDataProtection();
       ThankYouPage thankYouPage = contactPage.clickSendButton();
       assertTrue(thankYouPage.getSuccessText().contains("thank you"),
               "Successful text is incorrect");
    }
}
