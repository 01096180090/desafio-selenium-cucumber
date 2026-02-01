package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class InsurantDataPage {
    private final TestContext context;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "birthdate")
    private WebElement birthDateInput;

    @FindBy(xpath = "//*[text()='Male']")
    private WebElement genderMaleText;

    @FindBy(xpath = "//*[text()='Female']")
    private WebElement genderFemaleText;

    @FindBy(id = "streetaddress")
    private WebElement streetAddressInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "zipcode")
    private WebElement zipCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "occupation")
    private WebElement occupationDropdown;

    @FindBy(xpath = "//input[@id='speeding']/..")
    private WebElement hobbySpeeding;

    @FindBy(xpath = "//input[@id='bungeejumping']/..")
    private WebElement hobbyBungee;

    @FindBy(xpath = "//input[@id='cliffdiving']/..")
    private WebElement hobbyCliff;

    @FindBy(xpath = "//input[@id='skydiving']/..")
    private WebElement hobbySky;

    @FindBy(xpath = "//input[@id='other']/..")
    private WebElement hobbyOther;

    @FindBy(id = "website")
    private WebElement websiteInput;

    @FindBy(id = "picture")
    private WebElement pictureUpload;

    @FindBy(id = "nextenterproductdata")
    private WebElement nextButton;

    public InsurantDataPage(WebDriver driver, TestContext context) {
        this.context = context;
        PageFactory.initElements(driver, this);
    }

    public void fillInsurantForm(String firstName, String lastName, String birthDate,
                                 String gender, String street, String country, String zip,
                                 String city, String occupation, String website, String picturePath) {
        context.safeSendKeys(firstNameInput, firstName);
        context.safeSendKeys(lastNameInput, lastName);
        context.safeSendKeys(birthDateInput, birthDate);

        if (gender.equalsIgnoreCase("male")) {
            context.safeClick(genderMaleText);
        } else {
            context.safeClick(genderFemaleText);
        }

        context.safeSendKeys(streetAddressInput, street);
        context.safeSelectByVisibleText(countryDropdown, country);
        context.safeSendKeys(zipCodeInput, zip);
        context.safeSendKeys(cityInput, city);
        context.safeSelectByVisibleText(occupationDropdown, occupation);

        context.safeSendKeys(websiteInput, website);
        context.safeSendKeys(pictureUpload, picturePath);
    }

    public void selectHobbies(boolean speeding, boolean bungee, boolean cliff, boolean sky, boolean other) {
        if (speeding) context.safeClick(hobbySpeeding);
        if (bungee) context.safeClick(hobbyBungee);
        if (cliff) context.safeClick(hobbyCliff);
        if (sky) context.safeClick(hobbySky);
        if (other) context.safeClick(hobbyOther);
    }

    public void clickNext() {
        context.safeClick(nextButton);
    }
}
