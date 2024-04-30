package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Helper;
import utilities.ConfigReader;
import utilities.WaitHelper;
import java.util.List;

public class CheckoutPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url")+"checkout/" ;
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }
    @FindBy(id = "billing_first_name")
    private WebElement firstNameInputBox;
    @FindBy(id = "billing_last_name")
    private WebElement lastNameInputBox;
    @FindBy(id = "billing_address_1")
    private WebElement streetAddressInputBox;
    @FindBy(id = "billing_city")
    private WebElement cityNameInputBox;
    @FindBy(id = "billing_state")
    private WebElement stateDropdown;
    @FindBy(id = "billing_postcode")
    private WebElement postalCodeInputBox;
    @FindBy(id = "billing_email")
    private WebElement emailAddressInputBox;
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//li[contains(@data-id,'billing')]")
    private WebElement errorMessagelable;
    @FindBy(id = "payment_method_bacs")
    private WebElement directBankTransferRadioButton;
    @FindBy(id= "payment_method_cod")
    private WebElement cashOnDeliveryRadioButton;

    public void selectThePaymentMethod(String paymentMethod) {
       if(paymentMethod.equals("Direct bank transfer")){
          Helper.clickWithJS(directBankTransferRadioButton);
           logger.info("Selected the payment method is: " + paymentMethod);
       }else{
           Helper.clickWithJS(cashOnDeliveryRadioButton);
           logger.info("Selected the payment method is: " + paymentMethod);
       }

    }
    public void fillOutFirstName(String firstName) {
        fillOutField(firstName,firstNameInputBox);
        logger.info("Filled out first name with: " + firstName);
    }
    public void fillOutLastName(String lastName) {
        fillOutField(lastName,lastNameInputBox);
        logger.info("Filled out last name with: " + lastName);
    }
    public void fillOutStreetAddress(String streetName) {
        fillOutField(streetName,streetAddressInputBox);
        logger.info("Filled out street name with: " + streetName);
    }
    public void fillOutCityName(String cityName) {
        fillOutField(cityName,cityNameInputBox);
        logger.info("Filled out city name with: " + cityName);
    }
    public void chooseState (String state) {
        Select dropDownSelect = new Select(stateDropdown);
        List<WebElement> allOptions = dropDownSelect.getOptions();
        boolean stateFound = false;
        for (WebElement option:allOptions) {
            if(option.getText().startsWith(state)){
                dropDownSelect.selectByVisibleText(option.getText());
                logger.info("State is choose: " + state);
                stateFound = true;
                break;
            }
        }
        if (!stateFound) {
            logger.error("State not found: " + state);
        }
    }
    public void fillOutPostalCode(String postalCode) {
        fillOutField(postalCode,postalCodeInputBox);
        logger.info("Filled out postal code with: " + postalCode);
    }
    public void fillOutEmailAddress(String emailAddress) {
        fillOutField(emailAddress,emailAddressInputBox);
        logger.info("Filled out email address code with: " + emailAddress);
    }
    public void clickPlaceOrderButton() {
        Helper.clickWithJS(placeOrderButton);
        logger.info("Clicked on the place order button.");
    }
    public void fillOutField(String fieldValue,WebElement fieldInputBox) {
        WaitHelper.waitForVisibility(fieldInputBox,10);
        fieldInputBox.clear();
        fieldInputBox.sendKeys(fieldValue);
    }










}
