package page;

import BasePackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CombinPage extends DriverManager {


    @FindBy(css= ".filter-container>div:nth-child(1) i")
    public WebElement brandType;


    @FindBy(css = ".filter-container>div:nth-child(2) i")
    public WebElement categoryType;

    @FindBy(css = ".filter-container>div:nth-child(3) i")
    public WebElement sizeType;

    @FindBy(css = ".filter-container>div:nth-child(4) i")
   public WebElement colorType;

    @FindBy (css = ".product-box:nth-child(1)")
    public WebElement productBox;

    public void clickBrandType() {
        waitForElementClickable(brandType);
        click(brandType);
    }

    public void clickCategoryType() {
        waitForElementClickable(categoryType);
        click(categoryType);
    }

    public void clicksizeType() {
        waitForElementClickable(sizeType);
        click(sizeType);
    }

    public void clickcolorType() {
        waitForElementClickable(colorType);
        click(colorType);
    }

    public void clickproductBox() {
        //actionClick(productBox);
        waitForElementClickable(productBox);
        click(productBox);
    }

}
