package work;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WorkPage;

import static org.testng.Assert.*;

public class WorkTests extends BaseTest {

    @Test
    public void testHoverPartnersItem(){
        WorkPage workPage = homePage.clickClients();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var tooltip = workPage.hoverOverIcon(1);
        assertTrue(tooltip.isTooltipDisplayed(), "Tooltip not displayed");
        assertEquals(tooltip.getText(), "click to learn how we helped Jet redefine the digital showroom.", "tooltip text incorrect");
        assertTrue(tooltip.getLink().endsWith("/contact"), "Link Incorrect");
    }
}
