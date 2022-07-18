package ui;
import client.UserClient;
import com.github.javafaker.Faker;
import model.User;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import io.restassured.response.Response;

public class LoginUserTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    RestorePasswordPage restorePasswordPage;
    UserClient userClient = new UserClient();
    Response response;
    String accessToken;
    static Faker faker = new Faker();
    User user = new User(faker.internet().emailAddress(), faker.internet().password(), faker.name().username());

    @Before
    public void openMainPage() {
        // open main page
        mainPage = open(MainPage.pageUrl, MainPage.class);
        response = userClient.createUser(user);
        accessToken = response.then().extract().path("accessToken");
    }

    @Test
    public void checkUserLoginByEnterAccount() {

        mainPage.clickLoginButton();
        // initialize loginPage
        loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());
        loginPage.userLoginInput(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginInAccount() {

        mainPage.clickAccountButton();
        // initialize loginPage
        loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());
        // input account email and password
        loginPage.userLoginInput(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginOnRegistrationForm() {

        registerPage = open(RegisterPage.pageUrl, RegisterPage.class);
        registerPage.clickEnterButton();
        // initialize loginPage
        loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());
        // input account email and password
        loginPage.userLoginInput(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        assertTrue("Main page isn't displayed", loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserLoginOnRestorePasswordPage() {

        loginPage = open(LoginPage.pageUrl, LoginPage.class);
        loginPage.clickRestorePasswordButton();
        restorePasswordPage = page(RestorePasswordPage.class);
        assertTrue("Restore page isn't displayed", restorePasswordPage.isRestorePasswordFormIsDisplayed());

        restorePasswordPage.clickLoginButton();
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());
        // input account email and password
        loginPage.userLoginInput(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();
        mainPage = page(MainPage.class);
        assertTrue("Main page isn't displayed", mainPage.isMainPageLogoDisplayed());

    }

    @After
    public void deleteUser() { userClient.deleteUser(accessToken); }
}
