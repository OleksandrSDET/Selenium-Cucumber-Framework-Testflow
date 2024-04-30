package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.WaitHelper;

import java.util.List;

public class ProductsSteps {
    CartPage cartPage = new CartPage();
    ProductsPage productsPage = new ProductsPage();
    private int initialCartCount;
    private int countBeforeRemoval;
    @Given("I am on the Products page")
    public void i_am_on_the_products_page() {
        productsPage.loadPage();
    }
    @Given("the cart should be empty")
    public void the_cart_should_be_empty()  {
        initialCartCount=cartPage.getCartItemCount();
        Assert.assertEquals("The cart is not empty.", 0, initialCartCount);
    }
    @When("I add product with title {string} to the cart")
    public void i_add_product_with_title_to_the_cart(String productTitle) {
        productsPage.addToCart(productTitle);
    }
    @And("I click on the cart")
    public void i_click_on_the_cart() {
        productsPage.clickOnCart();
    }
    @Then("I verify product is successfully added to the cart")
    public void i_verify_product_is_successfully_added_to_the_cart()  {
        int currentCartCount = cartPage.getCartItemCount();
        Assert.assertNotEquals("The product was not added to the cart", initialCartCount, currentCartCount);
    }
    @And("I remove a product from the cart with title {string}")
    public void i_remove_a_product_from_the_cart_with_title(String productTitle)  {
        countBeforeRemoval= cartPage.getCartItemCount();
        cartPage.removeCartItem(productTitle,countBeforeRemoval);
    }
    @Then("the product should be removed")
    public void the_product_should_be_removed()  {
        int currentCartCount = cartPage.getCartItemCount();
        Assert.assertNotEquals("The product was not added to the cart", countBeforeRemoval, currentCartCount);
    }

    @Given("I sort products by category {string}")
    public void i_sort_products_by_category(String category) {
        productsPage.sortProductsByCategories(category);
    }
    @Then("products should be sorted by category {string}")
    public void products_should_be_sorted_by_category(String category) {
        Assert.assertEquals("Products are not sorted by "+category,category,productsPage.getProductHeaderTitle());
    }

    @When("I click on the product {string}")
    public void i_click_on_the_product(String productAttribute) {
        switch (productAttribute.toUpperCase()) {
            case "NAME":
                productsPage.clickOnTheItemName();
                break;
            case "IMAGE":
                productsPage.clickOnTheItemImage();
                break;
        }
    }
    @Then("I should redirected to the product detail page")
    public void i_should_redirected_to_the_product_detail_page() {
        Assert.assertTrue(productsPage.isOnProductDetailPage());
    }



}
