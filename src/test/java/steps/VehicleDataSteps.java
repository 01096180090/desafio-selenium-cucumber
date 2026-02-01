package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.VehicleDataPage;

public class VehicleDataSteps {
    WebDriver driver;
    VehicleDataPage vehiclePage;

    @Given("I am on the Vehicle Data page")
    public void openVehicleDataPage() {
        driver = new ChromeDriver();
        driver.get("https://sampleapp.tricentis.com/101/app.php");
        vehiclePage = new VehicleDataPage(driver);
    }

    @When("I fill in the vehicle information")
    public void fillVehicleInformation() {
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
    }

    @When("I proceed to the Insurant Data tab")
    public void proceedToInsurantData() {
        vehiclePage.clickNext();
    }

    @Then("I should see the Insurant Data form")
    public void validateInsurantDataForm() {
        // Verifica se o campo "First Name" da aba Insurant Data está visível
        boolean isVisible = driver.findElement(By.id("firstname")).isDisplayed();
        if (isVisible) {
            System.out.println("Insurant Data form is visible!");
        } else {
            System.out.println("Insurant Data form is NOT visible!");
        }
        driver.quit();
    }
}
