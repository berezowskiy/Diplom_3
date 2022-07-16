package ui;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import com.github.javafaker.Faker;

public class RegisterUserTest {

    RegisterPage registerPage;
    LoginPage loginPage;

    static Faker faker = new Faker();
    static String userEmail = faker.internet().emailAddress();
    static String userPassword = faker.internet().password();
    static String userName = faker.name().username();

    @Before
    public void openRegisterPage() {
        // open register page
        this.registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
    }

    @Test
    public void checkUserRegistration() {

        this.registerPage.userRegistrationInput(userName, userEmail, userPassword);
        this.registerPage.clickRegisterButton();
        // initialize loginPage
        this.loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserRegistrationIncorrectPassword() {

        this.registerPage.userRegistrationInput(userName, userEmail, userPassword.substring(0,5));
        this.registerPage.clickRegisterButton();
        assertTrue("Incorrect password error message isn't displayed", this.registerPage.isPasswordErrorMessageDisplayed());
    }
}
