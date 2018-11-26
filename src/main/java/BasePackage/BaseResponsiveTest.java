package BasePackage;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseResponsiveTest extends DriverManager {

    private String browserType = "Chrome";

    @Before
    public void browserOpen() {
        if (browserType.equals("Chrome")) {

            Map<String, String> mobileSimulation = new HashMap<>();
            mobileSimulation.put("browserName", "chrome");
            mobileSimulation.put("version", "70");
            mobileSimulation.put("device", "Pixel 2");

            ChromeOptions option = new ChromeOptions();
            option.setExperimentalOption("mobileEmulation", mobileSimulation);
            option.addArguments("window-size=414,736");

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, option);
            cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            cap.setCapability("chrome.switches", Arrays.asList("--incognito"));

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

            driver = new ChromeDriver(cap);
        }

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
