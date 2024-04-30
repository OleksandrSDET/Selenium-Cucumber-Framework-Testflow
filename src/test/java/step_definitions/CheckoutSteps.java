package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {

    CartPage carPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @Given("I click on proceed to checkout button")
    public void i_click_on_proceed_to_checkout_button() {
        carPage.clickOnProceedToCheckoutButton();
    }

    @When("I enter the first name {string}")
    public void i_enter_the_first_name(String firstName) {
        checkoutPage.fillOutFirstName(firstName);
    }
    @When("I enter the last name {string}")
    public void i_enter_the_last_name(String lastName) {
        checkoutPage.fillOutLastName(lastName);
    }
    @When("I enter street address {string}")
    public void i_enter_street_address(String streetName) {
        checkoutPage.fillOutStreetAddress(streetName);
    }
    @When("I enter city name {string}")
    public void i_enter_city_name(String cityName) {
        checkoutPage.fillOutCityName(cityName);
    }
    @When("I choose the state {string}")
    public void i_choose_the_state(String state) {
        checkoutPage.chooseState(state);
    }
    @When("I enter postal code {string}")
    public void i_enter_postal_code(String postalCode) {
        checkoutPage.fillOutPostalCode(postalCode);
    }
    @When("I enter email address {string}")
    public void i_enter_email_address(String emailAddress) {
        checkoutPage.fillOutEmailAddress(emailAddress);
    }
    @When("I click on place order button")
    public void i_click_on_place_order_button() {
        checkoutPage.clickPlaceOrderButton();
    }
}
