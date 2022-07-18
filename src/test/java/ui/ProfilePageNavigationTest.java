package ui;
import client.UserClient;
import io.restassured.response.Response;
import model.User;
import org.junit.*;
import com.github.javafaker.Faker;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ProfilePageNavigationTest {

    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    static Faker faker = new Faker();
    UserClient userClient = new UserClient();
    User user = new User(faker.internet().emailAddress(), faker.internet().password(), faker.name().username());
    Response response;
    String accessToken;

    @Before
    public void openLoginPage() {
        // open login page
        loginPage = open(LoginPage.pageUrl, LoginPage.class);
        response = userClient.createUser(user);
        accessToken = response.then().extract().path("accessToken");
    }

    @Test
    public void checkProfilePageNavigation() {

        loginPage.userLoginInput(user.getEmail(), user.getPassword());
        loginPage.clickLoginButton();

        mainPage = page(MainPage.class);
        mainPage.clickAccountButton();

        profilePage = page(ProfilePage.class);
        assertTrue("Profile page isn't displayed", profilePage.isProfilePageIsDisplayed());
        profilePage.clickLogo();
        assertTrue("Main page isn't displayed", mainPage.isMainPageLogoDisplayed());

        // back to account page
        mainPage.clickAccountButton();
        assertTrue("Profile page isn't displayed", profilePage.isProfilePageIsDisplayed());
        profilePage.clickConstructorButton();
        assertTrue("Profile page isn't displayed", profilePage.isProfilePageIsDisplayed());
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        assertTrue("Login page isn't displayed", loginPage.isLoginFormIsDisplayed());

    }

    @After
    public void deleteUser() { userClient.deleteUser(accessToken); }
}
