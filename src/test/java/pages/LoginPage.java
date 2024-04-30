package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigReader;
import utilities.WaitHelper;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url")+"account/";
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = ".woocommerce-button.button.woocommerce-form-login__submit")
    private WebElement loginButton;
    @FindBy(xpath = "//p[contains(text(),'Hello')]")
    private WebElement welcomeMessage;
    @FindBy(css = ".woocommerce-error li")
    private WebElement errorMessage;

    public void fillOutUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Filled out username with: " + username);
    }
    public void fillOutPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Filled out password with: " + "*".repeat(password.length()));
    }
    public void clickOnLoginButton() {
        WaitHelper.waitForClickablility(loginButton,10);
        loginButton.click();
        logger.info("Clicked login button.");
    }
    public String getErrorMessage(){
        String strErrorMessage = errorMessage.getText();
        logger.info("Retrieved error message: " + strErrorMessage);
        return strErrorMessage;
    }
    public String getWelcomeMessage(){
        String welcomeMessageText = welcomeMessage.getText();
        logger.info("Retrieved welcome message: " + welcomeMessageText);
        return welcomeMessageText;
    }







}
