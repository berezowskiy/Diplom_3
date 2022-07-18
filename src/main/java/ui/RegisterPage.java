package ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class RegisterPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/register";
    @FindBy(how = How.CLASS_NAME, using = "Auth_form__3qKeq")
    private SelenideElement registrationForm;
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    private ElementsCollection inputRegistrationFields;
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement enterButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    public boolean isPasswordErrorMessageDisplayed() {
        return this.errorMessage.isDisplayed();
    }
    public void scrollToRegisterForm() {
        this.registrationForm.scrollTo();
    }
    public void clickRegisterButton() {
        this.registerButton.click();
    }
    public void clickEnterButton() {
        this.enterButton.click();
    }
    public void userRegistrationInput(String name, String email, String password) {
        this.inputRegistrationFields.get(0).sendKeys(name);
        this.inputRegistrationFields.get(1).setValue(email);
        this.inputRegistrationFields.get(2).setValue(password);
    }
}
