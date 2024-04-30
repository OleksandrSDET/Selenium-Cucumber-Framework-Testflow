package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigReader;
import utilities.Helper;
import utilities.WaitHelper;

import java.util.List;

public class CartPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url")+"cart/";
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }
    @FindBy(xpath = "//div[@id='ast-desktop-header']//a[@class='cart-container']")
    private WebElement cartLink;
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = ".woocommerce-message")
    private WebElement removalConfirmationMessage;
    @FindBy(css = ".product-name>a")
    private List<WebElement> cartItemTitles;
    public void clickOnProceedToCheckoutButton() {
        WaitHelper.waitForClickablility(proceedToCheckoutButton,10);
        proceedToCheckoutButton.click();
        logger.info("Clicked on the proceed to checkout button.");
    }
    public void removeCartItem(String productTitle, int countBeforeRemoval) {
        for (WebElement item : cartItemTitles) {
            if (item.getText().equals(productTitle)) {
                WebElement removeButton = driver.findElement(By.xpath("//a[text()='" + productTitle + "']/../..//a[@class='remove']"));
                removeButton.click();
                String expectedValueInCart = String.valueOf(countBeforeRemoval-1);
                WaitHelper.waitForTextToBePresentInElement(cartLink,expectedValueInCart,5);
                Helper.scrollToElement(cartLink);
                logger.info("Element with title " + productTitle + " successfully removed from the cart.");
                return;
            }
        }
        logger.error("Item with title " + productTitle + " is not added to the cart. Removal skipped.");
    }
    public int getCartItemCount()  {
        try {
            int count = Integer.parseInt(cartLink.getText());
            logger.info("Cart item count retrieved: " + count);
            return count;
        } catch (Exception e) {
            logger.warn("Failed to retrieve cart item count.");
            return 0;
        }
    }
    public boolean isProductPresent(String productName) {
        for (WebElement item : cartItemTitles) {
            if (item.getText().equals(productName)) {
                logger.warn("Product named " + productName + " is present in the cart.");
                return true;
            }
        }
        logger.info("Product named " + productName + " is not present in the cart.");
        return false;
    }

}
