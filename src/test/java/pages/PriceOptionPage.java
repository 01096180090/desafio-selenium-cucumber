package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe que representa a aba "Select Price Option"
public class PriceOptionPage {
    WebDriver driver;

    // Planos de seguro
    @FindBy(xpath = "//input[@id='selectsilver']/..")
    WebElement silverOption;

    @FindBy(xpath = "//input[@id='selectgold']/..")
    WebElement goldOption;

    @FindBy(xpath = "//input[@id='selectplatinum']/..")
    WebElement platinumOption;

    @FindBy(xpath = "//input[@id='selectultimate']/..")
    WebElement ultimateOption;

    // Botão Next
    @FindBy(id = "nextsendquote")
    WebElement nextButton;

    public PriceOptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void safeClick(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else {
            System.out.println("Elemento não está pronto para clique: " + element);
        }
    }

    // Seleciona um plano
    public void selectPlan(String plan) {
        switch (plan.toLowerCase()) {
            case "silver":
                safeClick(silverOption);
                break;
            case "gold":
                safeClick(goldOption);
                break;
            case "platinum":
                safeClick(platinumOption);
                break;
            case "ultimate":
                safeClick(ultimateOption);
                break;
            default:
                System.out.println("Plano inválido: " + plan);
        }
    }

    public void clickNext() {
        safeClick(nextButton);
    }
}
