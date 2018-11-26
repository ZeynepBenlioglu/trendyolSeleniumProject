package page;

import BasePackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailPage extends DriverManager {

    @FindBy(xpath = "(//div[@id='boutiqueDetailContainer']//a)[2]")
            public WebElement containerType;

    @FindBy (xpath="//*[@id=\"basketForm\"]/div[2]/div[3]/button")
    public WebElement sizeSelect;

    public void clickProductDetailPage() {
        waitForElementClickable(containerType);
        doubleClick(containerType);

    }

    public void assertSizeSelect(String titleValue){
        waitForElementClickable(sizeSelect);
        assertEquals(getAttribute(sizeSelect,"title"),titleValue);

    }


}


