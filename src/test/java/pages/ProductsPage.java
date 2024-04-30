package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Helper;
import utilities.ConfigReader;
import utilities.WaitHelper;

import java.util.List;


public class ProductsPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url")+"store/" ;
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }
    @FindBy(xpath = "//div[@id='ast-desktop-header']//a[@class='cart-container']")
    private WebElement cartLink;
    @FindBy(css = ".ast-loop-product__link>h2")
    private List<WebElement> storeItemTitles;
    @FindBy(id = "product_cat")
    private WebElement sortProductsDropdown;
    @FindBy(css = ".woocommerce-products-header__title.page-title")
    private WebElement categoryPageLable;
    @FindBy(css = ".level-0")
    private List<WebElement> categoryDropdownOptions;
    @FindBy(css = ".ast-loop-product__link")
    private List<WebElement> inventoryItemNames;
    @FindBy(css = ".woocommerce-LoopProduct-link.woocommerce-loop-product__link")
    private List<WebElement> inventoryItemImages;
    @FindBy(css = ".woocommerce-products-header__title.page-title")
    private WebElement productHeaderTitle;

    public void addToCart(String productTitle) {
        for (WebElement item : storeItemTitles) {
            if (item.getText().equals(productTitle)) {
                WebElement addToCartButton = driver.findElement(By.xpath("//h2[text()='" +productTitle+ "']/../following-sibling::a"));
                addToCartButton.click();
                WebElement viewCartLink = driver.findElement(By.xpath("//h2[text()='" +productTitle+ "']/../following-sibling::a/following-sibling::a"));
                WaitHelper.waitForClickablility(viewCartLink,10);
                logger.info("Element with title " + productTitle + " successfully added to the cart.");
                return;
            }
        }
        logger.error("No such item title");
    }

    public void clickOnCart() {
        Helper.scrollToElement(cartLink);
        WaitHelper.waitForClickablility(cartLink,10);
        cartLink.click();
        logger.info("Clicked on the cart link."+cartLink.getAttribute("href"));
    }


    public void sortProductsByCategories(String category) {
        boolean categoryFound = false;
        for (WebElement option:categoryDropdownOptions) {
            if(option.getText().startsWith(category)){
                WaitHelper.waitForVisibility(sortProductsDropdown,10);
                sortProductsDropdown.click();
                option.click();
                logger.info("Products sorted by: " + category);
                categoryFound = true;
                break;
            }
        }
        if (!categoryFound) {
            logger.error("Category not found: " + category);
        }
    }

    public String getProductHeaderTitle(){
       return productHeaderTitle.getText().replace("'","’");
    }

    public void clickOnTheItemName() {
        inventoryItemNames.get(0).click();
    }

    public void clickOnTheItemImage() {
        inventoryItemImages.get(0).click();
    }

    public boolean isOnProductDetailPage() {
        return driver.getCurrentUrl().contains("/product/");
    }


}
