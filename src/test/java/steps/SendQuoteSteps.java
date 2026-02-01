package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.VehicleDataPage;
import pages.InsurantDataPage;
import pages.ProductDataPage;
import pages.PriceOptionPage;
import pages.SendQuotePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.WebElement;


public class SendQuoteSteps {
    WebDriver driver;
    VehicleDataPage vehiclePage;
    InsurantDataPage insurantPage;
    ProductDataPage productPage;
    PriceOptionPage pricePage;
    SendQuotePage sendQuotePage;

    @Given("I am on the Send Quote page")
    public void openSendQuotePage() {
        driver = new ChromeDriver();
        driver.get("https://sampleapp.tricentis.com/101/app.php");

        vehiclePage = new VehicleDataPage(driver);
        insurantPage = new InsurantDataPage(driver);
        productPage = new ProductDataPage(driver);
        pricePage = new PriceOptionPage(driver);
        sendQuotePage = new SendQuotePage(driver);

        // Fluxo completo até chegar no Send Quote
        vehiclePage.fillVehicleForm("Audi", "Scooter", "1500", "1200",
                "01/01/2020", "4", "2", "Petrol",
                "500", "1500", "20000", "ABC1234",
                "15000", true);
        vehiclePage.clickNext();

        insurantPage.fillInsurantForm("Marcelo", "Camargo", "01/10/1984",
                "male", "Main Street 123", "Brazil", "90000",
                "Porto Alegre", "Employee",
                "https://www.linkedin.com/in/marcelocb/", "/path/to/pic.jpg");
        insurantPage.selectHobbies(true, false, true, false, false); // Speeding + Cliff Diving
        insurantPage.clickNext();

        productPage.fillProductForm("06/01/2026", "3000000", "Bonus 1",
                "Full Coverage", "Yes");
        productPage.clickNext();

        pricePage.selectPlan("Silver");
        pricePage.clickNext();
    }

    @When("I fill in the send quote information")
    public void fillSendQuoteInformation() {
        sendQuotePage.fillSendQuoteForm("teste@teste.com", "555123456",
                "marceloUser", "Test56", "Test56",
                "Automação de teste concluída!");
    }

    @When("I send the quote")
    public void sendQuote() {
        sendQuotePage.clickSend();
    }

    @Then("I should see the success message")
    public void validateSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
