package page;

import BasePackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoutiqueDetailPage extends DriverManager {

    @FindBy(xpath = "(//*[@id='dynamic-boutiques']/div/div/div)[1]")
    public WebElement trendcombinpage;

    public void clickTrendCombinPage() {
        waitForElementClickable(trendcombinpage);
        click(trendcombinpage);
    }

}
