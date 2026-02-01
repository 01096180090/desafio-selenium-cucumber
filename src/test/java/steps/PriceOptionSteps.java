package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import support.TestContext;

public class PriceOptionSteps {
    private TestContext context;

    public PriceOptionSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Price Option page")
    public void openPriceOptionPage() {
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

        context.getProductPage().fillProductForm(
                "06/01/2026", "3.000.000,00", "Bonus 1",
                "Full Coverage", "Yes"
        );
        context.getProductPage().clickNext();
    }

    @When("I select the {string} plan")
    public void selectPlan(String plan) {
        context.getPricePage().selectPlan(plan);
    }

    @When("I proceed to the Send Quote tab")
    public void proceedToSendQuote() {
        context.getPricePage().clickNext();
    }

    @Then("I should see the Send Quote form")
    public void validateSendQuoteForm() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));
        WebElement sendQuoteForm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        Assert.assertTrue("Expected Send Quote form to be visible", sendQuoteForm.isDisplayed());

        context.quitDriver();
    }
}
