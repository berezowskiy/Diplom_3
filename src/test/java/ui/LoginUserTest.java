package ui;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginUserTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    RestorePasswordPage restorePasswordPage;
    String correctEmail = "qa_diploma@yandex.ru";
    String correctPassword = "qa12345";

    @Before
    public void openMainPage() {
        // open main page
        this.mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
    }

    @Test
    public void checkUserLoginByEnterAccount() {

        this.mainPage.clickLoginButton();
        // initialize loginPage
        this.loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
        this.loginPage.userLoginInput(correctEmail, correctPassword);
        this.loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginInAccount() {

        this.mainPage.clickAccountButton();
        // initialize loginPage
        this.loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
        // input account email and password
        this.loginPage.userLoginInput(correctEmail, correctPassword);
        this.loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginOnRegistrationForm() {

        this.registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        this.registerPage.clickEnterButton();
        // initialize loginPage
        this.loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
        // input account email and password
        this.loginPage.userLoginInput(correctEmail, correctPassword);
        this.loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginOnRestorePasswordPage() {

        this.loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        this.loginPage.clickRestorePasswordButton();
        this.restorePasswordPage = page(RestorePasswordPage.class);
        assertTrue("Restore page isn't displayed", this.restorePasswordPage.isRestorePasswordFormIsDisplayed());

        this.restorePasswordPage.clickLoginButton();
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());
        // input account email and password
        this.loginPage.userLoginInput(correctEmail, correctPassword);
        this.loginPage.clickLoginButton();
        this.mainPage = page(MainPage.class);
        assertTrue("Main page isn't displayed", this.mainPage.isMainPageLogoDisplayed());

    }
}
