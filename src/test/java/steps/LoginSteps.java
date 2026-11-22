package steps;

import static org.junit.jupiter.api.Assertions.*;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void openLogin() {
        loginPage = new LoginPage(Hooks.getDriver());
        loginPage.open();
    }

    @When("I login with {string} and {string}")
    public void login(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("I should see the products page")
    public void productsPage() {
        assertEquals("Products", loginPage.getTitle());
    }

    @Then("I should see the error {string}")
    public void errorShown(String msg) {
        assertTrue(loginPage.getError().contains(msg));
    }
    
    @When("I add the product {string} to the cart")
    public void addProduct(String product) {
        new InventoryPage(Hooks.getDriver()).addToCart(product);
    }

    @Then("the cart badge should show {string}")
    public void badgeShows(String count) {
        assertEquals(count, new InventoryPage(Hooks.getDriver()).getBadgeCount());
    }
}