package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe que representa a aba "Vehicle Data"
public class VehicleDataPage {
    WebDriver driver;

    // Campos obrigatórios da aba Vehicle Data
    @FindBy(id = "make")
    WebElement makeDropdown;

    @FindBy(id = "model")
    WebElement modelDropdown;

    @FindBy(id = "cylindercapacity")
    WebElement cylinderCapacityInput;

    @FindBy(id = "engineperformance")
    WebElement enginePerformanceInput;

    @FindBy(id = "dateofmanufacture")
    WebElement manufactureDateInput;

    @FindBy(id = "numberofseats")
    WebElement seatsDropdown;

    @FindBy(id = "numberofseatsmotorcycle")
    WebElement seatsMotorcycleDropdown;

    @FindBy(id = "fuel")
    WebElement fuelDropdown;

    @FindBy(id = "payload")
    WebElement payloadInput;

    @FindBy(id = "totalweight")
    WebElement totalWeightInput;

    @FindBy(id = "listprice")
    WebElement listPriceInput;

    @FindBy(id = "licenseplatenumber")
    WebElement licensePlateInput;

    @FindBy(id = "annualmileage")
    WebElement annualMileageInput;

    // Right Hand Drive (radio button)
    @FindBy(xpath = "//input[@id='righthanddriveyes']/..")
    WebElement rightHandDriveYes;

    @FindBy(xpath = "//input[@id='righthanddriveno']/..")
    WebElement rightHandDriveNo;

    // Botão Next para ir para Insurant Data
    @FindBy(id = "nextenterinsurantdata")
    WebElement nextButton;

    public VehicleDataPage(WebDriver driver) {
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

    // Método para preencher o formulário de Vehicle Data
    public void fillVehicleForm(String make, String model, String cylinderCapacity, String performance, String date,
                                String seats, String seatsMotorcycle, String fuel, String payload, String weight,
                                String price, String plate, String mileage, boolean rightHandDrive) {
        safeSendKeys(makeDropdown, make);
        safeSendKeys(modelDropdown, model);
        safeSendKeys(cylinderCapacityInput, cylinderCapacity);
        safeSendKeys(enginePerformanceInput, performance);
        safeSendKeys(manufactureDateInput, date);
        safeSendKeys(seatsDropdown, seats);
        safeSendKeys(seatsMotorcycleDropdown, seatsMotorcycle);
        safeSendKeys(fuelDropdown, fuel);
        safeSendKeys(payloadInput, payload);
        safeSendKeys(totalWeightInput, weight);
        safeSendKeys(listPriceInput, price);
        safeSendKeys(licensePlateInput, plate);
        safeSendKeys(annualMileageInput, mileage);

        if (rightHandDrive) {
            safeClick(rightHandDriveYes);
        } else {
            safeClick(rightHandDriveNo); }

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    // Avançar para a aba Insurant Data
    public void clickNext() {
        safeClick(nextButton);
    }
}
