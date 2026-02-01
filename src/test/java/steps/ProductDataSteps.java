package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import support.TestContext;

public class ProductDataSteps {
    private TestContext context;

    public ProductDataSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Product Data page")
    public void openProductDataPage() {
        context.getDriver().get("https://sampleapp.tricentis.com/101/app.php");

        context.getVehiclePage().fillVehicleForm(
                "Audi",
                "Scooter",
                "1500",
                "1200",
                "01/01/2020",
                "4",
                "2",
                "Petrol",
                "500",
                "1500",
                "20000",
                "ABC1234",
                "15000",
                true
        );
        context.getVehiclePage().clickNext();

        context.getInsurantPage().fillInsurantForm(
                "Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg"
        );
        context.getInsurantPage().selectHobbies(true, false, true, false, false);
        context.getInsurantPage().clickNext();
    }

    @When("I fill in the product information")
    public void fillProductInformation() {
        context.getProductPage().fillProductForm(
                "06/01/2026", "3.000.000,00", "Bonus 1",
                "Full Coverage", "Yes"
        );
    }

    @When("I proceed to the Price Option tab")
    public void proceedToPriceOption() {
        context.getProductPage().clickNext();
    }

    @Then("I should see the Price Option form")
    public void validatePriceOptionForm() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
        WebElement priceOptionForm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("selectsilver"))
        );

        Assert.assertTrue("Expected Price Option form to be visible", priceOptionForm.isDisplayed());

        context.quitDriver();
    }
}
