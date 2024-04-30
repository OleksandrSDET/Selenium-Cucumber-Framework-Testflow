package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckoutPage;
import pages.OverviewPage;

public class OverviewSteps {

    OverviewPage overviewPage = new OverviewPage();
    CheckoutPage  checkoutPage = new  CheckoutPage();

    @When("I select the product {string}")
    public void i_select_the_product(String paymentMethod) {
        checkoutPage.selectThePaymentMethod(paymentMethod);
    }
    @Then("I should see the payment method message {string}")
    public void i_should_see_the_payment_method_message(String expectedMessage) {
        String actualMessage = overviewPage.getpaymentMethodConfirmationMessage();
        Assert.assertEquals("Payment method wasn't selected, order was not placed", expectedMessage, actualMessage);
        Assert.assertTrue("Payment method wasn't selected, order was not placed", actualMessage.contains(expectedMessage));
    }

    @Then("I should see {string} message")
    public void i_should_see_message(String expectedMessage) {
        String actualMessage = overviewPage.getConfirmationMessage();
        Assert.assertEquals("Checkout wasn't completed, order was not placed", expectedMessage, actualMessage);
        Assert.assertTrue("Checkout wasn't completed, order was not placed", actualMessage.contains(expectedMessage));
    }




}
