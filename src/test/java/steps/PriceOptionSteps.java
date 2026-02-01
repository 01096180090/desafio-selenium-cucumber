package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.VehicleDataPage;
import pages.InsurantDataPage;
import pages.ProductDataPage;
import pages.PriceOptionPage;

public class PriceOptionSteps {
    WebDriver driver;
    VehicleDataPage vehiclePage;
    InsurantDataPage insurantPage;
    ProductDataPage productPage;
    PriceOptionPage pricePage;

    @Given("I am on the Price Option page")
    public void openPriceOptionPage() {
        driver = new ChromeDriver();
        driver.get("https://sampleapp.tricentis.com/101/app.php");

        vehiclePage = new VehicleDataPage(driver);
        insurantPage = new InsurantDataPage(driver);
        productPage = new ProductDataPage(driver);
        pricePage = new PriceOptionPage(driver);

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

        // Preenche Product Data
        productPage.fillProductForm("06/01/2026", "3000000", "Bonus 1",
                "Full Coverage", "Yes");
        productPage.clickNext();
    }

    @When("I select the {string} plan")
    public void selectPlan(String plan) {
        pricePage.selectPlan(plan);
    }

    @When("I proceed to the Send Quote tab")
    public void proceedToSendQuote() {
        pricePage.clickNext();
    }

    @Then("I should see the Send Quote form")
    public void validateSendQuoteForm() {
        boolean isVisible = driver.findElement(By.id("email")).isDisplayed();
        if (isVisible) {
            System.out.println("Send Quote form is visible!");
        } else {
            System.out.println("Send Quote form is NOT visible!");
        }

        // Espera 5 segundos para visualizar antes de fechar
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        driver.quit();
    }
}
