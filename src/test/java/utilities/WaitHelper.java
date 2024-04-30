package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;


public class WaitHelper {

    private static final Logger logger = LoggerFactory.getLogger(WaitHelper.class);

    public static void wait(int secs) {
        logger.info("Waiting for " + secs + " seconds.");
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException e) {
            logger.error("An exception occurred during wait", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForClickablility(WebElement element, int timeToWaitInSec) {
        logger.info("Waiting up to " + timeToWaitInSec + " seconds for element to be clickable.");
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), Duration.ofSeconds(timeToWaitInSec));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("Element is now clickable.");
        } catch (Exception e) {
            logger.error("Element was not clickable after " + timeToWaitInSec + " seconds", e);
        }
    }

    public static void waitForTextToBePresentInElement(WebElement element, String text, int timeToWaitInSec) {
        logger.info("Waiting for text to be present in element for " + timeToWaitInSec + " seconds. Text: " + text);
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), Duration.ofSeconds(timeToWaitInSec));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            logger.error("An exception occurred while waiting for text to be present in element: " + e.getMessage(), e);
            throw e;
        }
    }
    public static void waitForElementToDisappear(WebElement element, int timeToWaitInSec) {
        logger.info("Waiting for invisibility of element for " + timeToWaitInSec + " seconds.");
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), Duration.ofSeconds(timeToWaitInSec));
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            logger.error("An exception occurred while waiting for element invisibility: " + e.getMessage(), e);
            throw e;
        }
    }
    public static void waitForVisibility(WebElement element, int timeToWaitInSec) {
        logger.info("Waiting for visibility of element for " + timeToWaitInSec + " seconds.");
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), Duration.ofSeconds(timeToWaitInSec));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("An exception occurred while waiting for element visibility: " + e.getMessage(), e);
            throw e;
        }
    }

}