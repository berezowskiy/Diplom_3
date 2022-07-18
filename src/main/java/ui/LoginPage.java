package ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/login";
    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
    private SelenideElement loginForm;
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    private ElementsCollection loginInputFields;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private ElementsCollection additionalLoginPageButtons;

    public boolean isLoginFormIsDisplayed() {
        return this.loginForm.isDisplayed();
    }


    public void userLoginInput(String email, String password) {
        this.loginInputFields.get(0).setValue(email);
        this.loginInputFields.get(1).setValue(password);
    }

    public void clickLoginButton() { this.loginButton.click(); }
    public void clickRestorePasswordButton() { this.additionalLoginPageButtons.get(1).click(); }
}
