package page;

import BasePackage.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainClass extends DriverManager {

    @FindBy(xpath = "//div[@class='homepage-popup-content'][1]//span[@class='homepage-popup-gender']")
    public WebElement female;


    public void clickFemalePopup() {
        waitForElementClickable(female);
        click(female);
    }





}

