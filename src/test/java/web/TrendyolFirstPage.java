package web;

import BasePackage.BaseWebTest;
import enums.URLFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.BoutiqueDetailPage;
import page.CombinPage;
import page.MainClass;
import page.ProductDetailPage;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class TrendyolFirstPage extends BaseWebTest {

    MainClass mainClass;
    BoutiqueDetailPage boutiquedetail;
    CombinPage combinPage;
    ProductDetailPage ProductDetail;

    @Before
    public void setup() {
        mainClass = PageFactory.initElements(BaseWebTest.driver, MainClass.class);
        boutiquedetail = PageFactory.initElements(BaseWebTest.driver, BoutiqueDetailPage.class);
        combinPage = PageFactory.initElements(BaseWebTest.driver, CombinPage.class);
        ProductDetail = PageFactory.initElements(BaseWebTest.driver, ProductDetailPage.class);

        //driver.manage().window().setSize(new Dimension(500,700));

    }


    @Test
    public void selectFemale() throws MalformedURLException, InterruptedException {


        navigateToURL(URLFactory.MAIN_PAGE);

        Assert.assertTrue(driver.getCurrentUrl().contains(URLFactory.MAIN_PAGE.link));
        mainClass.clickFemalePopup();
        Thread.sleep(2000);

        WebElement trendyolMillaElement = driver.findElement(By.xpath("(//img[contains(@title, 'TRENDYOLMİLLA')])[1]//parent::a/parent::div/following-sibling::div"));
        waitForElementClickable(trendyolMillaElement);
        click(trendyolMillaElement);
        combinPage.clickBrandType();


            By brand = By.xpath("//label[@for='TRENDYOLMİLLA']");
            waitForElementClickable(driver.findElement(brand));
            click(driver.findElement(brand));

        Thread.sleep(1000);
        assert driver.findElements(By.xpath("//div[contains(text(), 'TRENDYOLMİLLA')]")).size() > 1;

        combinPage.clickCategoryType();

        List<WebElement> categoryOptions = driver.findElements(By.xpath("//div[@class='filter-item-dropdown']//li/div/div"));
        List<String> categoryOptionText = new ArrayList<String>();


        try {
            IntStream.range(0, categoryOptions.size())
                    .forEach(element -> {
                        waitForElementClickable(categoryOptions.get(element));
                        scrollToElement(categoryOptions.get(element));
                        click(categoryOptions.get(element));

                        assert categoryOptions.get(element).getAttribute("class").equals("checkbox selected");

                    });
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }


        combinPage.clickCategoryType();


        /*List<String> categoryName = new ArrayList<String>();
        //categoryName.add("Atkı");
        categoryName.add("Babet");
        categoryName.add("Bluz");
        categoryName.add("Body");
        for (int i = 0; i < categoryName.size(); i++) {
            By category = By.xpath("//label[@for='" + categoryName.get(i) + "']");
            click(driver.findElement(category));
            Thread.sleep(1000);
        }*/


        combinPage.clicksizeType();

        List<String> sizeType = new ArrayList<String>();
        sizeType.add("2");
        sizeType.add("5");
        sizeType.add("8");


        for (int i = 0; i < sizeType.size(); i++) {
            By size = By.cssSelector("div.block-list-scroll-wrapper > div:nth-child(" + sizeType.get(i) + ")");
            click(driver.findElement(size));
            Thread.sleep(1000);
        }




       combinPage.clickcolorType();

        List<String> colorType = new ArrayList<String>();
        colorType.add("Bej");
        colorType.add("Gri");
        colorType.add("Kırmızı");
        for (int i = 0; i < colorType.size(); i++) {
            try {
                By category = By.xpath("//span[text()='" + colorType.get(i) + "']");
                click(driver.findElement(category));
            } catch  (Exception e) {

            }
        }
       combinPage.clickcolorType();


        Thread.sleep(2000);

        combinPage.clickproductBox();
        ProductDetail.clickProductDetailPage();
        ProductDetail.assertSizeSelect("S");

    }


}
