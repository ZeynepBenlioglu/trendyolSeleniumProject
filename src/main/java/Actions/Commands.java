package Actions;

import BasePackage.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Commands extends BaseClass {

    public static void click(WebElement element) {
        element.click();
    }

    public static void actionClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().build().perform();
    }

    public static void comboboxSelectByValue(WebElement element, String value) {

        new Select(element).selectByValue(value);
    }

    public static void sendKeys(WebElement element, CharSequence value) {
        element.sendKeys(value);

    }

    public static void assertEquals(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);

    }

    public static String getAttribute(WebElement element, String attributename) {
       return element.getAttribute(attributename);
    }

    public static void navigateToURL(URL url) {

        driver.navigate().to(url);

    }

}
