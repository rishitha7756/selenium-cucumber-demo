package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginJUnitTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void validLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertEquals("Products", driver.findElement(By.className("title")).getText());
    }

    @Test
    void lockedUser() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String err = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertTrue(err.contains("locked out"));
    }
    
    @Test
    void validLoginWithPage() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("standard_user", "secret_sauce");
        assertEquals("Products", login.getTitle());
    }
}