package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By badge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart(String product) {
        String id = "add-to-cart-sauce-labs-" + product.toLowerCase();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public String getBadgeCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(badge)).getText();
    }
}