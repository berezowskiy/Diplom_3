package ui;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {

    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
    private SelenideElement restorePasswordForm;

    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement restoreButton;
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginButton;

    public void clickLoginButton() { this.loginButton.click(); }
    public boolean isRestorePasswordFormIsDisplayed() { return this.restorePasswordForm.isDisplayed(); }
}
