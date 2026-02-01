package steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import support.TestContext;


public class SendQuoteSteps {
    TestContext context;

    public SendQuoteSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the Send Quote page")
    public void openSendQuotePage() {
        context.getDriver().get("https://sampleapp.tricentis.com/101/app.php");

        // Fluxo completo até chegar no Send Quote
        context.getVehiclePage().fillVehicleForm("Audi", "Scooter", "1500", "1200",
                "01/01/2020", "4", "2", "Petrol",
                "500", "1500", "20000", "ABC1234",
                "15000", true);
        context.getVehiclePage().clickNext();

        context.getInsurantPage().fillInsurantForm("Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg");
        context.getInsurantPage().selectHobbies(true, false, true, false, false); // Speeding + Cliff Diving
        context.getInsurantPage().clickNext();

        context.getProductPage().fillProductForm("06/01/2026", "3000000", "Bonus 1",
                "Full Coverage", "Yes");
        context.getProductPage().clickNext();

        context.getPricePage().selectPlan("Silver");
        context.getPricePage().clickNext();
    }

    @When("I fill in the send quote information")
    public void fillSendQuoteInformation() {
        context.getSendQuotePage().fillSendQuoteForm("teste@teste.com", "555123456",
                "marceloUser", "Test56", "Test56",
                "Automação de teste concluída!");
    }

    @When("I send the quote")
    public void sendQuote() {
        context.getSendQuotePage().clickSend();
    }

    @Then("I should see the success message")
    public void validateSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(15));

        // Espera até que o popup com a mensagem apareça
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Sending e-mail success!')]")
                )
        );

        if (successMessage.isDisplayed()) {
            System.out.println("Mensagem de sucesso exibida!");
        } else {
            System.out.println("Mensagem de sucesso NÃO exibida!"); }

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))
        );
        okButton.click();

        // Espera 5 segundos para visualizar antes de fechar
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        context.getDriver().quit();
    }
}
