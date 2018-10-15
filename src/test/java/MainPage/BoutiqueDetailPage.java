package MainPage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Actions.Commands.click;
import static Actions.Commands.waitForElementClickable;

public class BoutiqueDetailPage extends BaseClass  {

    @FindBy(xpath = "(//*[@id='dynamic-boutiques']/div/div/div)[1]")
    public WebElement trendcombinpage;

    public void clickTrendCombinPage() {
        waitForElementClickable(trendcombinpage);
        click(trendcombinpage);
    }

}
