package BasePackage;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseWebTest extends DriverManager{

    private String browserType = "Chrome";


    @Before
    public void browserOpen() {
        if (browserType.equals("Chrome")) {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            cap.setCapability("chrome.switches", Arrays.asList("--incognito"));
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

            driver = new ChromeDriver(cap);
        } else if (browserType.equals("Edge")) {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            cap.setCapability("ie.ensureCleanSession", true);

            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver(cap);

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @After
    public void browserClosed() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
