package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class VehicleDataPage {
    private final TestContext context;

    @FindBy(id = "make")
    private WebElement makeDropdown;

    @FindBy(id = "model")
    private WebElement modelDropdown;

    @FindBy(id = "cylindercapacity")
    private WebElement cylinderCapacityInput;

    @FindBy(id = "engineperformance")
    private WebElement enginePerformanceInput;

    @FindBy(id = "dateofmanufacture")
    private WebElement manufactureDateInput;

    @FindBy(id = "numberofseats")
    private WebElement seatsDropdown;

    @FindBy(id = "numberofseatsmotorcycle")
    private WebElement seatsMotorcycleDropdown;

    @FindBy(id = "fuel")
    private WebElement fuelDropdown;

    @FindBy(id = "payload")
    private WebElement payloadInput;

    @FindBy(id = "totalweight")
    private WebElement totalWeightInput;

    @FindBy(id = "listprice")
    private WebElement listPriceInput;

    @FindBy(id = "licenseplatenumber")
    private WebElement licensePlateInput;

    @FindBy(id = "annualmileage")
    private WebElement annualMileageInput;

    @FindBy(xpath = "//input[@id='righthanddriveyes']/..")
    private WebElement rightHandDriveYes;

    @FindBy(xpath = "//input[@id='righthanddriveno']/..")
    private WebElement rightHandDriveNo;

    @FindBy(id = "nextenterinsurantdata")
    private WebElement nextButton;

    public VehicleDataPage(WebDriver driver, TestContext context) {
        this.context = context;
        PageFactory.initElements(driver, this);
    }

    public void fillVehicleForm(String make, String model, String cylinderCapacity, String performance, String date,
                                String seats, String seatsMotorcycle, String fuel, String payload, String weight,
                                String price, String plate, String mileage, boolean rightHandDrive) {
        context.safeSelectByVisibleText(makeDropdown, make);
        context.safeSelectByVisibleText(modelDropdown, model);
        context.safeSendKeys(cylinderCapacityInput, cylinderCapacity);
        context.safeSendKeys(enginePerformanceInput, performance);
        context.safeSendKeys(manufactureDateInput, date);
        context.safeSelectByVisibleText(seatsDropdown, seats);
        context.safeSelectByVisibleText(seatsMotorcycleDropdown, seatsMotorcycle);
        context.safeSelectByVisibleText(fuelDropdown, fuel);
        context.safeSendKeys(payloadInput, payload);
        context.safeSendKeys(totalWeightInput, weight);
        context.safeSendKeys(listPriceInput, price);
        context.safeSendKeys(licensePlateInput, plate);
        context.safeSendKeys(annualMileageInput, mileage);

        if (rightHandDrive) {
            context.safeClick(rightHandDriveYes);
        } else {
            context.safeClick(rightHandDriveNo);
        }
    }

    public void clickNext() {
        context.safeClick(nextButton);
    }
}
