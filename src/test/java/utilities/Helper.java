package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Helper {

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getInstance().getDriver()).executeScript("arguments[0].click();", element);
    }

}



