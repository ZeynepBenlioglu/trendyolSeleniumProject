package MainPage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Actions.Commands.click;
import static Actions.Commands.waitForElementClickable;


public class MainClass extends BaseClass {

    @FindBy(xpath = "//div[@class='homepage-popup-content'][1]//span[@class='homepage-popup-gender']")
    public WebElement female;


    public void clickFemalePopup() {
        waitForElementClickable(female);
        click(female);
    }





}

