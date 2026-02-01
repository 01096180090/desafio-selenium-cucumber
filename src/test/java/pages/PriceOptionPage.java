package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class PriceOptionPage {
    private final TestContext context;

    @FindBy(xpath = "//input[@id='selectsilver']/..")
    private WebElement silverOption;

    @FindBy(xpath = "//input[@id='selectgold']/..")
    private WebElement goldOption;

    @FindBy(xpath = "//input[@id='selectplatinum']/..")
    private WebElement platinumOption;

    @FindBy(xpath = "//input[@id='selectultimate']/..")
    private WebElement ultimateOption;

    @FindBy(id = "nextsendquote")
    private WebElement nextButton;

    public PriceOptionPage(WebDriver driver, TestContext context) {
        this.context = context;
        PageFactory.initElements(driver, this);
    }

    public void selectPlan(String plan) {
        switch (plan.toLowerCase()) {
            case "silver":
                context.safeClick(silverOption);
                break;
            case "gold":
                context.safeClick(goldOption);
                break;
            case "platinum":
                context.safeClick(platinumOption);
                break;
            case "ultimate":
                context.safeClick(ultimateOption);
                break;
            default:
                throw new IllegalArgumentException("Plano inválido: " + plan);
        }
    }

    public void clickNext() {
        context.safeClick(nextButton);
    }
}
