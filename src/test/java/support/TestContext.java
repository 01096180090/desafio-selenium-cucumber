package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SendQuotePage;
import pages.VehicleDataPage;
import pages.InsurantDataPage;
import pages.ProductDataPage;
import pages.PriceOptionPage;

public class TestContext {
    private WebDriver driver;
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

    public VehicleDataPage getVehiclePage() {
        if (vehiclePage == null) {
            vehiclePage = new VehicleDataPage(driver);
        }
        return vehiclePage;
    }

    public InsurantDataPage getInsurantPage() {
        if (insurantPage == null) {
            insurantPage = new InsurantDataPage(driver);
        }
        return insurantPage;
    }

    public ProductDataPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductDataPage(driver);
        }
        return productPage;
    }

    public PriceOptionPage getPricePage() {
        if (pricePage == null) {
            pricePage = new PriceOptionPage(driver);
        }
        return pricePage;
    }

    public SendQuotePage getSendQuotePage() {
        if (sendQuotePage == null) {
            sendQuotePage = new SendQuotePage(driver);
        }
        return sendQuotePage;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
