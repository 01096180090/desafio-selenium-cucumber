package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import support.TestContext;

public class SendQuoteSteps {
    private TestContext context;

    public SendQuoteSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Send Quote page")
    public void openSendQuotePage() {
        context.getDriver().get("https://sampleapp.tricentis.com/101/app.php");

        context.getVehiclePage().fillVehicleForm(
                "Audi", "Scooter", "1500", "1200",
                "01/01/2020", "4", "2", "Petrol",
                "500", "1500", "20000", "ABC1234",
                "15000", true
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

        context.getPricePage().selectPlan("Silver");
        context.getPricePage().clickNext();
    }

    @When("I fill in the send quote information")
    public void fillSendQuoteInformation() {
        context.getSendQuotePage().fillSendQuoteForm(
                "teste@teste.com", "555123456",
                "marceloUser", "Test56", "Test56",
                "Automação de teste concluída!"
        );
    }

    @When("I send the quote")
    public void sendQuote() {
        context.getSendQuotePage().clickSend();
    }

    @Then("I should see the success message")
    public void validateSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));

        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Sending e-mail success!')]")
                )
        );

        Assert.assertTrue(
                "Expected success popup 'Sending e-mail success!' to be visible",
                successMessage.isDisplayed()
        );

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))
        );
        okButton.click();

        context.quitDriver();
    }
}
