//Create Methods to call the work page, then scroll down to the client's panel, and validate the information of one client doing mouse hover.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WorkPage {
    private WebDriver driver;

    private By partnerItem = By.className("z-partners-list-item");
    private By boxTooltip = By.className("tooltip");

    public WorkPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */

    public Tooltip hoverOverIcon(int index){
        WebElement partner = driver.findElements(partnerItem).get(index + 14);

        Actions actions = new Actions(driver);
        actions.moveToElement(partner).perform();

        return new Tooltip(partner.findElement(boxTooltip));
    }

    public class Tooltip{

        private WebElement tooltip;
        private By text = By.tagName("a");
        private By link = By.tagName("a");

        public Tooltip(WebElement tooltip){
            this.tooltip = tooltip;
        }

        public boolean isTooltipDisplayed(){
            return tooltip.isDisplayed();
        }

        public String getText(){
            return tooltip.findElement(text).getText();
        }

        public String getLink(){
            return tooltip.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return tooltip.findElement(link).getText();
        }
    }
}
