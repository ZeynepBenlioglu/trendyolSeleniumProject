package MainPage;

import BasePackage.BaseClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static Actions.Commands.click;
import static Actions.Commands.navigateToURL;

public class TrendyolFirstPage extends BaseClass {

    MainClass mainClass;
    BoutiqueDetailPage boutiquedetail;
    CombinPage combinPage;
    ProductDetailPage ProductDetail;

    @Before
    public void setup() {
        mainClass = PageFactory.initElements(BaseClass.driver, MainClass.class);
        boutiquedetail = PageFactory.initElements(BaseClass.driver, BoutiqueDetailPage.class);
        combinPage = PageFactory.initElements(BaseClass.driver, CombinPage.class);
        ProductDetail = PageFactory.initElements(BaseClass.driver, ProductDetailPage.class);

    }


    @Test
    public void selectFemale() throws MalformedURLException, InterruptedException {

        navigateToURL(new URL("https://www.trendyol.com/"));

        mainClass.clickFemalePopup();
        Thread.sleep(2000);
        boutiquedetail.clickTrendCombinPage();

        /*combinPage.clickBrandType();


        List<String> brandType = new ArrayList<String>();
        brandType.add("TRENDYOLMİLLA");
        brandType.add("Vavist");

        for (int i = 0; i < brandType.size(); i++) {
            By category = By.xpath("//label[@for='" + brandType.get(i) + "']");
            click(driver.findElement(category));
        }
*/

        combinPage.clickCategoryType();

        List<WebElement> categoryOptions = driver.findElements(By.xpath("//div[@class='filter-item-dropdown']//li//label"));
        List<String> categoryOptionText = new ArrayList<String>();

        categoryOptions.forEach(element -> {
            categoryOptionText.add(element.getAttribute("for"));
            By category = By.xpath("//label[@for='" + element.getAttribute("for") + "']");
            click(driver.findElement(category));
        });


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
        //sizeType.add("5");
        //sizeType.add("8");


        for (int i = 0; i < sizeType.size(); i++) {
            By size = By.cssSelector("div.block-list-scroll-wrapper > div:nth-child(" + sizeType.get(i) + ")");
            click(driver.findElement(size));
            Thread.sleep(1000);
        }




      /* combinPage.clickcolorType();

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

        */
        Thread.sleep(2000);

        combinPage.clickproductBox();
        ProductDetail.clickProductDetailPage();
        ProductDetail.assertSizeSelect("S");

    }


}
