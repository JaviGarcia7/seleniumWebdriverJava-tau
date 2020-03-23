package jobs;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.JobsPage;
import pages.ThankYouPage;

import static org.testng.Assert.assertTrue;

public class JobsTests extends BaseTest {

    @Test
    public void testSuccessfulJobsInfo(){
        JobsPage jobsPage = homePage.clickJobs();
        jobsPage.setYourName("This is an Automation Test on Jobs Page");
        jobsPage.setYourEmail("test.qa1@mailinator.com");
        jobsPage.setMobilePhoneNumber("5146072167");
        jobsPage.setPortfolioLink("http://wwww.domain.tld");
        jobsPage.setGoodAtText("Fusce ac felis sit amet ligula pharetra condimentum. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.");
        ThankYouPage thankYouPage = jobsPage.clickSendButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(thankYouPage.getThankYouText().contains("thank you"),
                "Successful text is incorrect");
    }
}
