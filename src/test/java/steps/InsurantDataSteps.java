package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.VehicleDataPage;
import pages.InsurantDataPage;

public class InsurantDataSteps {
    WebDriver driver;
    VehicleDataPage vehiclePage;
    InsurantDataPage insurantPage;

    @Given("I am on the Insurant Data page")
    public void openInsurantDataPage() {
        driver = new ChromeDriver();
        driver.get("https://sampleapp.tricentis.com/101/app.php");
        vehiclePage = new VehicleDataPage(driver);
        insurantPage = new InsurantDataPage(driver);

        // Preenche Vehicle Data para chegar na aba Insurant Data
        vehiclePage.fillVehicleForm(
                "Audi",    // Make
                "Scooter",       // Model
                "1500",          // Cylinder Capacity
                "1200",          // Engine Performance
                "01/01/2020",    // Date of Manufacture
                "4",             // Number of Seats
                "2",             // Number of Seats Motorcycle
                "Petrol",        // Fuel Type
                "500",           // Payload
                "1500",          // Total Weight
                "20000",         // List Price
                "ABC1234",       // License Plate
                "15000",         // Annual Mileage
                true             // Right Hand Drive
        );
        vehiclePage.clickNext();
    }

    @When("I fill in the insurant information")
    public void fillInsurantInformation() {
        insurantPage.fillInsurantForm("Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg");
        insurantPage.selectHobbies(true, false, true, false, false); // Speeding + Cliff Diving
    }

    @When("I proceed to the Product Data tab")
    public void proceedToProductData() {
        insurantPage.clickNext();
    }

    @Then("I should see the Product Data page")
    public void validateProductDataPage() {
        // Aqui você pode validar se um elemento da aba Product Data está visível
        driver.quit();
    }
}
