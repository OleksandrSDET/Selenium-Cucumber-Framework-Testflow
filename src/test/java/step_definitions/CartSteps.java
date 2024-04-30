package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps {
    CartPage cartPage = new CartPage();
    @Then("the cart should no longer contain product {string}")
    public void the_cart_should_no_longer_contain_product(String expectedProductName) {
        Assert.assertFalse("Product " + expectedProductName + " was not removed from the cart", cartPage.isProductPresent(expectedProductName));
    }
}
