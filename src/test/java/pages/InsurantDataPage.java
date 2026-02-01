package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe que representa a aba "Insurant Data"
public class InsurantDataPage {
    WebDriver driver;

    // Campos obrigatórios
    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "birthdate")
    WebElement birthDateInput;

    // Gênero (clicando no texto visível)
    @FindBy(xpath = "//*[text()='Male']")
    WebElement genderMaleText;

    @FindBy(xpath = "//*[text()='Female']")
    WebElement genderFemaleText;

    @FindBy(id = "streetaddress")
    WebElement streetAddressInput;

    @FindBy(id = "country")
    WebElement countryDropdown;

    @FindBy(id = "zipcode")
    WebElement zipCodeInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "occupation")
    WebElement occupationDropdown;

    // Hobbies (clicando no pai do input)
    @FindBy(xpath = "//input[@id='speeding']/..")
    WebElement hobbySpeeding;

    @FindBy(xpath = "//input[@id='bungeejumping']/..")
    WebElement hobbyBungee;

    @FindBy(xpath = "//input[@id='cliffdiving']/..")
    WebElement hobbyCliff;

    @FindBy(xpath = "//input[@id='skydiving']/..")
    WebElement hobbySky;

    @FindBy(xpath = "//input[@id='other']/..")
    WebElement hobbyOther;

    // Website
    @FindBy(id = "website")
    WebElement websiteInput;

    // Upload de imagem
    @FindBy(id = "picture")
    WebElement pictureUpload;

    // Botão Next
    @FindBy(id = "nextenterproductdata")
    WebElement nextButton;

    public InsurantDataPage(WebDriver driver) {
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

    // Método para preencher o formulário completo
    public void fillInsurantForm(String firstName, String lastName, String birthDate,
                                 String gender, String street, String country, String zip,
                                 String city, String occupation, String website, String picturePath) {
        safeSendKeys(firstNameInput, firstName);
        safeSendKeys(lastNameInput, lastName);
        safeSendKeys(birthDateInput, birthDate);

        // Seleciona gênero dinamicamente
        if (gender.equalsIgnoreCase("male")) {
            safeClick(genderMaleText);
        } else {
            safeClick(genderFemaleText);
        }

        safeSendKeys(streetAddressInput, street);
        safeSendKeys(countryDropdown, country);
        safeSendKeys(zipCodeInput, zip);
        safeSendKeys(cityInput, city);
        safeSendKeys(occupationDropdown, occupation);

        safeSendKeys(websiteInput, website);
        safeSendKeys(pictureUpload, picturePath);
    }

    // Método para selecionar hobbies dinamicamente
    public void selectHobbies(boolean speeding, boolean bungee, boolean cliff, boolean sky, boolean other) {
        if (speeding) safeClick(hobbySpeeding);
        if (bungee) safeClick(hobbyBungee);
        if (cliff) safeClick(hobbyCliff);
        if (sky) safeClick(hobbySky);
        if (other) safeClick(hobbyOther);
    }

    // Avançar para a aba Product Data
    public void clickNext() {
        safeClick(nextButton);
    }
}
