package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.cucumber.java.en.*;
import pages.*;
import support.TestContext;

public class SendQuoteErrorSteps {
    private TestContext context;

    public SendQuoteErrorSteps(TestContext context) {
        this.context = context;
    }

    @When("I fill in the send quote information with mismatched passwords")
    public void fillSendQuoteInformationWithError() {
        context.getSendQuotePage().fillSendQuoteForm("teste@teste.com", "555123456",
                "marceloUser", "Test56", "Test65",
                "Teste com senha inválida");
    }

    @Then("I should see an error message preventing submission")
    public void validateErrorMessage() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));

        // Valida popup de erro
        WebElement popupMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.sweet-alert")
                )
        );

        String messageText = popupMessage.getText();
        if (messageText.contains("Not finished yet")) {
            System.out.println("Popup de erro exibido corretamente!");
        } else {
            System.out.println("Mensagem inesperada: " + messageText);
        }

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))
        );
        okButton.click();

        context.getDriver().quit();
    }
}
