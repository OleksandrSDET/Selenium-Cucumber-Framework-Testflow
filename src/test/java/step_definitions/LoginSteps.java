package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    @Given("I land on AskOmDch Account page")
    public void i_land_on_ask_om_dch_home_page() {
        loginPage.loadPage();
    }

    @When("I enter a username {string}")
    public void i_enter_a_username(String username) {
        loginPage.fillOutUsername(username);
    }

    @When("I enter a password {string}")
    public void i_enter_a_password(String password) {
        loginPage.fillOutPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("I should be able to see the {string} message")
    public void i_should_be_able_to_see_the_message(String message) {
        Assert.assertTrue("Welcome message is not displayed", loginPage.getWelcomeMessage().contains(message));
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String errorMessage) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals("Expected and actual error messages do not match ", errorMessage, actualError);
    }

}
