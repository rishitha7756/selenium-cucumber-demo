package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;

    public static WebDriver getDriver() { return driver; }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", "failure");
        }
        driver.quit();
    }
}