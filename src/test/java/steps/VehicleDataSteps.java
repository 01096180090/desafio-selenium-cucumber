package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import support.TestContext;

public class VehicleDataSteps {
    private TestContext context;

    public VehicleDataSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Vehicle Data page")
    public void openVehicleDataPage() {
        context.getDriver().get("https://sampleapp.tricentis.com/101/app.php");
    }

    @When("I fill in the vehicle information")
    public void fillVehicleInformation() {
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
    }

    @When("I proceed to the Insurant Data tab")
    public void proceedToInsurantData() {
        context.getVehiclePage().clickNext();
    }

    @Then("I should see the Insurant Data form")
    public void validateInsurantDataForm() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
        WebElement insurantDataForm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))
        );

        Assert.assertTrue("Expected Insurant Data form to be visible", insurantDataForm.isDisplayed());

        context.quitDriver();
    }
}
