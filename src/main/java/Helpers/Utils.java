package Helpers;

import BasePackage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Utils extends BaseClass {

    public static void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            System.out.println(jsExecutor.executeScript("return self.name"));

        } catch (Exception e) {
        }
    }

    public static WebElement switchToParentFrameFindElem(WebElement element) {
        WebElement we = null;
        try {
            driver.switchTo().parentFrame();
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            we = element;
        } catch (Exception e) {
        }
        return we;
    }

    public static WebElement switchToChildFrameFindElem(WebElement element, int childNo) {
        WebElement we = null;
        try {
            WebElement frame = driver.findElements(By.xpath(".//iframe")).get(childNo);

            driver.switchTo().frame(frame);
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            we = element;
            System.out.println("You are in this child frame: " + frame.getAttribute("id"));
        } catch (Exception e) {
        }
        return we;
    }

    public static void switchToChildFrame(int childNo) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            System.out.println("before switchToChildFrame > You are in this child frame: " + jsExecutor.executeScript("return self.name"));
            System.out.println("size :    " + driver.findElements(By.tagName("iframe")).size());

            Thread.sleep(3);
            driver.switchTo().frame(childNo);
            System.out.println("after switchToChildFrame > You are in this child frame: " + jsExecutor.executeScript("return self.name"));
        } catch (Exception e) {
            System.out.println("switchToChildFrame > You are in this child frame: " + e.toString());
        }
    }

    public static void switchToChildFrame(WebElement we) {
        try {
            driver.switchTo().frame(we);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            System.out.println("switchToChildFrame(WebElement we) -> You are in this child frame: " + jsExecutor.executeScript("return self.name"));
        } catch (Exception e) {
            System.out.println("switchToChildFrame > You are in this child frame: " + e.toString());
        }
    }

    public static WebElement switchToFrameFindElem(WebElement element) {
        driver.switchTo().defaultContent();
        WebElement we = null;
        List<WebElement> framesList2 = driver.findElements(By.xpath("//iframe"));
        List<List<String>> framesListHierarchycal = new ArrayList<List<String>>();
        for (WebElement frame : framesList2) {

            List<String> temp = new ArrayList<String>();
            temp.add(0, frame.getAttribute("id"));
            driver.switchTo().frame(frame);

            System.out.println("switch to frame -> " + temp.get(0));
            List<WebElement> temp2 = driver.findElements(By.xpath(".//iframe"));
            if (temp2.size() > 0) {
                for (int z = 0; z < temp2.size(); z++) {
                    temp.add(temp2.get(z).getAttribute("id"));
                }
            }
            framesListHierarchycal.add(temp);
            driver.switchTo().defaultContent();
        }

        int k = 0;
        for (List<String> frameList : framesListHierarchycal) {

            for (int f = 0; f < frameList.size(); f++) {

                //System.out.println((k) + "frame" + f + "  " + frameList);

                if (f == 0) {
                    try {
                        driver.switchTo().frame(driver.findElement(By.id(frameList.get(f))));
                        WebDriverWait wait = new WebDriverWait(driver, 3);
                        wait.until(ExpectedConditions.elementToBeClickable(element));
                        we = element;

                    } catch (org.openqa.selenium.TimeoutException t) {

                    } catch (Exception e) {

                    }

                } else {
                    try {
                        driver.switchTo().frame(driver.findElement(By.id(frameList.get(f))));
                        WebDriverWait wait = new WebDriverWait(driver, 3);
                        wait.until(ExpectedConditions.elementToBeClickable(element));
                        we = element;
                        // System.out.println("switch to frame -> " + frameList.get(f));
                    } catch (org.openqa.selenium.TimeoutException t) {
                        driver.switchTo().parentFrame();
                    } catch (Exception e) {
                        driver.switchTo().parentFrame();
                    }
                }
                if (we != null) {
                    System.out.println("you are in this frame -> " + frameList.get(f));
                    return we;
                }
            }
            driver.switchTo().defaultContent();
            k++;
        }
        return we;
    }

}
