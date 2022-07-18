package ui;
import client.UserClient;
import model.User;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import com.github.javafaker.Faker;

public class RegisterUserTest {

    RegisterPage registerPage;
    LoginPage loginPage;
    static Faker faker = new Faker();
    UserClient userClient = new UserClient();
    User user = new User(faker.internet().emailAddress(), faker.internet().password(), faker.name().username());
    String accessToken;

    @Before
    public void openRegisterPage() {
        // open register page
        registerPage = open(RegisterPage.pageUrl, RegisterPage.class);
    }

    @Test
    public void checkUserRegistration() {

        registerPage.userRegistrationInput(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        // initialize loginPage
        loginPage = page(LoginPage.class);
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());
    }

    @Test
    public void checkUserRegistrationIncorrectPassword() {
        user.setPassword(user.getPassword().substring(0,5));
        registerPage.userRegistrationInput(user.getName(), user.getEmail(), user.getPassword());
        registerPage.clickRegisterButton();
        assertTrue("Incorrect password error message isn't displayed", registerPage.isPasswordErrorMessageDisplayed());
    }

    @After
    public void deleteUser() {
        if(userClient.loginUser(user).getStatusCode() == 200) {
            accessToken = userClient.loginUser(user).then().extract().path("accessToken");
            userClient.deleteUser(accessToken);
        }

    }
}
