package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.cucumber.java.en.*;
import org.junit.Assert;
import support.TestContext;

public class SendQuoteErrorSteps {
    private final TestContext context;

    public SendQuoteErrorSteps(TestContext context) {
        this.context = context;
    }

    @When("I fill in the send quote information with mismatched passwords")
    public void fillSendQuoteInformationWithError() {
        context.getSendQuotePage().fillSendQuoteForm(
                "teste@teste.com", "555123456",
                "marceloUser", "Test56", "Test65",
                "Teste com senha inválida"
        );
    }

    @Then("I should see an error message preventing submission")
    public void validateErrorMessage() {
        WebDriverWait wait = new WebDriverWait(context.getDriver(), Duration.ofSeconds(10));

        WebElement popupMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sweet-alert"))
        );

        String messageText = popupMessage.getText();
        Assert.assertTrue(
                "Expected popup message to contain 'Not finished yet', but got: " + messageText,
                messageText.contains("Not finished yet")
        );

        context.quitDriver();
    }
}
