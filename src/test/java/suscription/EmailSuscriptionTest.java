package suscription;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailSuscriptionPage;
import pages.ThankYouPage;

import static org.testng.Assert.*;

public class EmailSuscriptionTest extends BaseTest {

    @Test
    public void testEmailSuscription(){
        EmailSuscriptionPage suscriptionPage = homePage.clickBlog();
        suscriptionPage.enterEmail("test8.qa@gmail.com");
        ThankYouPage emailSentMessage = suscriptionPage.clickSuscribe();
        assertTrue(emailSentMessage.getCheckEmailText().contains("Please check your email to confirm your subscription"),
                "Something happened. Please make sure the email is valid");
    }

}
