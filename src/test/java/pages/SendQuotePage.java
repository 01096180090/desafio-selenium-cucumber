package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe que representa a aba "Send Quote"
public class SendQuotePage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "confirmpassword")
    WebElement confirmPasswordInput;

    @FindBy(id = "Comments")
    WebElement commentsInput;

    @FindBy(id = "sendemail")
    WebElement sendButton;

    public SendQuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void safeSendKeys(WebElement element, String value) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.sendKeys(value);
        } else {
            System.out.println("Elemento não está pronto para interação: " + element);
        }
    }

    private void safeClick(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else {
            System.out.println("Elemento não está pronto para clique: " + element);
        }
    }

    // Preenche o formulário de Send Quote
    public void fillSendQuoteForm(String email, String phone, String username,
                                  String password, String confirmPassword, String comments) {
        safeSendKeys(emailInput, email);
        safeSendKeys(phoneInput, phone);
        safeSendKeys(usernameInput, username);
        safeSendKeys(passwordInput, password);
        safeSendKeys(confirmPasswordInput, confirmPassword);
        safeSendKeys(commentsInput, comments);
    }

    // Envia a cotação
    public void clickSend() {
        safeClick(sendButton);
    }
}
