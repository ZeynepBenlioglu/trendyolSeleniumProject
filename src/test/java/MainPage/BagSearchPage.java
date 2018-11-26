package MainPage;



import BasePackage.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

import static Actions.Commands.*;

public class BagSearchPage extends BaseClass {


    MainClass mainClass;
    BoutiqueDetailPage boutiquedetail;

    @Before
    public void setup() {
        mainClass = PageFactory.initElements(BaseClass.driver, MainClass.class);
        boutiquedetail = PageFactory.initElements(BaseClass.driver, BoutiqueDetailPage.class);

       // driver.manage().window().setSize(new Dimension(500,700));


    }

    @Test
    public void selectFemale() throws MalformedURLException, InterruptedException {
        String homePage="https://www.trendyol.com/";
        navigateToURL(new URL(homePage));

        Assert.assertTrue(driver.getCurrentUrl().contains(homePage));
        mainClass.clickFemalePopup();
        Thread.sleep(2000);

        WebElement trendyolMillaElement = driver.findElement(By.xpath("(//img[contains(@title, 'TRENDYOLMİLLA')])[1]//parent::a/parent::div/following-sibling::div"));
        waitForElementClickable(trendyolMillaElement);
        click(trendyolMillaElement);

        WebElement searchElement=driver.findElement(By.id("AutoCompleteBox"));
        waitForElementClickable(searchElement);

        searchElement.sendKeys("Çanta");
        WebElement searchClick=driver.findElement(By.xpath("//*[@id='searchWrapper']/div[2]"));
        waitForElementClickable(searchClick);
        click(searchClick);
        assert driver.findElements(By.className("pname")).size() > 1;


        List<WebElement> searchresult = driver.findElements(By.className("pname"));


        try {
            IntStream.range(0, searchresult.size())
                    .forEach(element -> {
                        waitForElementClickable(searchresult.get(element));
                        scrollToElement(searchresult.get(element));

                        System.out.println(searchresult.get(element).getText().toLowerCase());
                       // assert searchresult.get(element).getText().toLowerCase().contains("çanta")  || searchresult.get(element).getText().toLowerCase().contains("freebag") ;


                    });
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        catch (AssertionError asex) {
            asex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assert driver.findElements(By.xpath("//*[@id=\"mCSB_3\"]//span[contains(text(), 'Siyah')]")).size() == 1;

        WebElement ColorType= driver.findElement(By.xpath("//*[@id=\"mCSB_3\"]//span[contains(text(), 'Siyah')]"));
        waitForElementClickable(ColorType);
        click(ColorType);

        Thread.sleep(2000);

        String min = "61";
        String max = "69";

        WebElement minfiyatsearchclick = driver.findElement(By.xpath("//*[@id=\"left-panel\"]/div/div[11]/div[2]/input[1]"));
        waitForElementClickable(minfiyatsearchclick);
        scrollToElement(minfiyatsearchclick);
        minfiyatsearchclick.click();
        minfiyatsearchclick.sendKeys(min);



        WebElement maxfiyatsearchclick=driver.findElement(By.xpath("//*[@id=\"maxRange\"]"));
        maxfiyatsearchclick.sendKeys(max);

        //waitForElementClickable(maxfiyatsearchclick);

        WebElement searchPriceClick=driver.findElement(By.xpath("//*[@id=\"left-panel\"]/div/div[11]/div[2]/input[3]"));
        waitForElementClickable(searchPriceClick);
        click(searchPriceClick);


        List<WebElement> priceresult = driver.findElements(By.className("prspr"));



        try {
            IntStream.range(0, priceresult.size())
                    .forEach(element -> {
                        waitForElementClickable(priceresult.get(element));
                        scrollToElement(priceresult.get(element));
                        float f = Float.parseFloat(priceresult.get(element).getText().split("\\s+")[0].replace(",", "."));
                        System.out.println(f+"");
                        assert f <= Float.parseFloat(max) && f >= Float.parseFloat("90");

                    });
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        catch (AssertionError asex) {
            asex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
      // henüz yapılmadı  assert driver.findElements(By.xpath("//*[@id=\"mCSB_3\"]//span[contains(text(), 'Siyah')]")).size() == 123;

        Thread.sleep(10000);

    }



}
