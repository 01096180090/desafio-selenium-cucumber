package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe que representa a aba "Product Data"
public class ProductDataPage {
    WebDriver driver;

    // Campos obrigatórios da aba Product Data
    @FindBy(id = "startdate")
    WebElement startDateInput;

    @FindBy(id = "insurancesum")
    WebElement insuranceSumDropdown;

    @FindBy(id = "meritrating")
    WebElement meritRatingDropdown;

    @FindBy(id = "damageinsurance")
    WebElement damageInsuranceDropdown;

    @FindBy(xpath = "//input[@id='EuroProtection']/..")
    WebElement euroProtectionCheckbox;

    @FindBy(id = "courtesycar")
    WebElement courtesyCarDropdown;

    // Botão Next para ir para Select Price Option
    @FindBy(id = "nextselectpriceoption")
    WebElement nextButton;

    public ProductDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Método para verificar se o campo está pronto (visível e habilitado)
    private void safeSendKeys(WebElement element, String value) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.sendKeys(value);
        } else {
            System.out.println("Elemento não está pronto para interação: " + element);
        }
    }

    private void safeClick(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else {
            System.out.println("Elemento não está pronto para clique: " + element);
        }
    }

    // Método para preencher o formulário de Product Data
    public void fillProductForm(String startDate, String insuranceSum, String meritRating,
                                String damageInsurance, String courtesyCar) {
        safeSendKeys(startDateInput, startDate);
        safeSendKeys(insuranceSumDropdown, insuranceSum);
        safeSendKeys(meritRatingDropdown, meritRating);
        safeSendKeys(damageInsuranceDropdown, damageInsurance);
        safeClick(euroProtectionCheckbox);
        safeSendKeys(courtesyCarDropdown, courtesyCar);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Avançar para a aba Select Price Option
    public void clickNext() {
        safeClick(nextButton);
    }
}
