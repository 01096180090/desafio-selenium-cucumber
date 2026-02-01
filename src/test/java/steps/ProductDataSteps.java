package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.VehicleDataPage;
import pages.InsurantDataPage;
import pages.ProductDataPage;

public class ProductDataSteps {
    WebDriver driver;
    VehicleDataPage vehiclePage;
    InsurantDataPage insurantPage;
    ProductDataPage productPage;

    @Given("I am on the Product Data page")
    public void openProductDataPage() {
        driver = new ChromeDriver();
        driver.get("https://sampleapp.tricentis.com/101/app.php");

        vehiclePage = new VehicleDataPage(driver);
        insurantPage = new InsurantDataPage(driver);
        productPage = new ProductDataPage(driver);

        // Preenche Vehicle Data
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

        // Preenche Insurant Data
        insurantPage.fillInsurantForm("Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg");
        insurantPage.selectHobbies(true, false, true, false, false); // Speeding + Cliff Diving
        insurantPage.clickNext();
    }

    @When("I fill in the product information")
    public void fillProductInformation() {
        productPage.fillProductForm("06/01/2026", "3000000", "Bonus 1",
                "Full Coverage", "Yes");
    }

    @When("I proceed to the Price Option tab")
    public void proceedToPriceOption() {
        productPage.clickNext();
    }

    @Then("I should see the Price Option form")
    public void validatePriceOptionForm() {
        // Verifica se o campo da aba Price Option está visível
        boolean isVisible = driver.findElement(By.id("selectsilver")).isDisplayed();
        if (isVisible) {
            System.out.println("Price Option form is visible!");
        } else {
            System.out.println("Price Option form is NOT visible!");
        }
        driver.quit();
    }
}
