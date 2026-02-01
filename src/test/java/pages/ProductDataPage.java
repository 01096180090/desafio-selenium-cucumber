package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class ProductDataPage {
    private final TestContext context;

    @FindBy(id = "startdate")
    private WebElement startDateInput;

    @FindBy(id = "insurancesum")
    private WebElement insuranceSumDropdown;

    @FindBy(id = "meritrating")
    private WebElement meritRatingDropdown;

    @FindBy(id = "damageinsurance")
    private WebElement damageInsuranceDropdown;

    @FindBy(xpath = "//input[@id='EuroProtection']/..")
    private WebElement euroProtectionCheckbox;

    @FindBy(id = "courtesycar")
    private WebElement courtesyCarDropdown;

    @FindBy(id = "nextselectpriceoption")
    private WebElement nextButton;

    public ProductDataPage(WebDriver driver, TestContext context) {
        this.context = context;
        PageFactory.initElements(driver, this);
    }

    public void fillProductForm(String startDate, String insuranceSum, String meritRating,
                                String damageInsurance, String courtesyCar) {
        context.safeSendKeys(startDateInput, startDate);
        context.safeSelectByVisibleText(insuranceSumDropdown, insuranceSum);
        context.safeSelectByVisibleText(meritRatingDropdown, meritRating);
        context.safeSelectByVisibleText(damageInsuranceDropdown, damageInsurance);
        context.safeClick(euroProtectionCheckbox);
        context.safeSelectByVisibleText(courtesyCarDropdown, courtesyCar);
    }

    public void clickNext() {
        context.safeClick(nextButton);
    }
}
