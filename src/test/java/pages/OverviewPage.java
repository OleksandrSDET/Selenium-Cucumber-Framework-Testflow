package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigReader;

public class OverviewPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(OverviewPage.class);
    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url")+"checkout/order-received/";
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    @FindBy(css = ".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")
    private WebElement orderConfirmationMessage;
    @FindBy(xpath = "//th[text()='Payment method:']/../td")
    private WebElement paymentMethodConfirmationMessage;
    public String getConfirmationMessage() {
        String confirmationMsg = orderConfirmationMessage.getText();
        logger.info("Retrieved order confirmation message: " + confirmationMsg);
        return confirmationMsg;
    }
    public String getpaymentMethodConfirmationMessage() {
        String confirmationMsg = paymentMethodConfirmationMessage.getText();
        logger.info("Retrieved payment Method confirmation message: " + confirmationMsg);
        return confirmationMsg;
    }

}
