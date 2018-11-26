package responsive;

import BasePackage.BaseResponsiveTest;
import enums.URLFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductSearchTest extends BaseResponsiveTest {

    @Test
    public void productSearchFilter() {

        navigateToURL(URLFactory.MAIN_PAGE_MOBILE);


        WebElement searchElement = driver.findElement(By.className("search-autofill__input"));
        waitForElementClickable(searchElement);
        click(searchElement);
        WebElement searchElementSendKeys = driver.findElement(By.className("search-panel__input"));

        searchElementSendKeys.sendKeys("Çanta");
        //WebElement searchClick = driver.findElement(By.xpath("//*[@id='searchWrapper']/div[2]"));
        List<WebElement> searchresultlist = driver.findElements(By.cssSelector("div.latest-searches__list a"));
        WebElement bag = searchresultlist.get(0);
        Assert.assertEquals("Çanta", getAttribute(bag, "title"));
        click(bag);

    }
}
