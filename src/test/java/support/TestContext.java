package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.time.Duration;

public class TestContext {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private final WebDriver driver;
    private VehicleDataPage vehiclePage;
    private InsurantDataPage insurantPage;
    private ProductDataPage productPage;
    private PriceOptionPage pricePage;
    private SendQuotePage sendQuotePage;

    public TestContext() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void safeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void safeSendKeys(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void safeSelectByVisibleText(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public VehicleDataPage getVehiclePage() {
        if (vehiclePage == null) {
            vehiclePage = new VehicleDataPage(driver, this);
        }
        return vehiclePage;
    }

    public InsurantDataPage getInsurantPage() {
        if (insurantPage == null) {
            insurantPage = new InsurantDataPage(driver, this);
        }
        return insurantPage;
    }

    public ProductDataPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductDataPage(driver, this);
        }
        return productPage;
    }

    public PriceOptionPage getPricePage() {
        if (pricePage == null) {
            pricePage = new PriceOptionPage(driver, this);
        }
        return pricePage;
    }

    public SendQuotePage getSendQuotePage() {
        if (sendQuotePage == null) {
            sendQuotePage = new SendQuotePage(driver, this);
        }
        return sendQuotePage;
    }

    public void quitDriver() {
        driver.quit();
    }
}
