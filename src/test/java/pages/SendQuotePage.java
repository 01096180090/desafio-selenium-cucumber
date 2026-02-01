package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.TestContext;

public class SendQuotePage {
    private final TestContext context;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "Comments")
    private WebElement commentsInput;

    @FindBy(id = "sendemail")
    private WebElement sendButton;

    public SendQuotePage(WebDriver driver, TestContext context) {
        this.context = context;
        PageFactory.initElements(driver, this);
    }

    public void fillSendQuoteForm(String email, String phone, String username,
                                  String password, String confirmPassword, String comments) {
        context.safeSendKeys(emailInput, email);
        context.safeSendKeys(phoneInput, phone);
        context.safeSendKeys(usernameInput, username);
        context.safeSendKeys(passwordInput, password);
        context.safeSendKeys(confirmPasswordInput, confirmPassword);
        context.safeSendKeys(commentsInput, comments);
    }

    public void clickSend() {
        context.safeClick(sendButton);
    }
}
