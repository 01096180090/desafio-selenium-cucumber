package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import support.TestContext;

public class InsurantDataSteps {
    private TestContext context;

    public InsurantDataSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Insurant Data page")
    public void openInsurantDataPage() {
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
    }

    @When("I fill in the insurant information")
    public void fillInsurantInformation() {
        context.getInsurantPage().fillInsurantForm(
                "Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg"
        );
        context.getInsurantPage().selectHobbies(true, false, true, false, false);
    }

    @When("I proceed to the Product Data tab")
    public void proceedToProductData() {
        context.getInsurantPage().clickNext();
    }

    @Then("I should see the Product Data page")
    public void validateProductDataPage() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
        WebElement productDataForm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("startdate"))
        );

        Assert.assertTrue("Expected Product Data form to be visible", productDataForm.isDisplayed());

        context.quitDriver();
    }
}
