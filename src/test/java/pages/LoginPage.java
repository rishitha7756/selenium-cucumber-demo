package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");
    private final By title = By.className("title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public String getError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).getText();
    }
}