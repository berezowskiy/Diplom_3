package ui;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ProfilePageNavigationTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    RestorePasswordPage restorePasswordPage;
    ProfilePage profilePage;
    String correctEmail = "qa_diploma@yandex.ru";
    String correctPassword = "qa12345";

    @Before
    public void openLoginPage() {
        // open login page
        this.loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
    }

    @Test
    public void checkProfilePageNavigation() {

        this.loginPage.userLoginInput(correctEmail, correctPassword);
        this.loginPage.clickLoginButton();
        this.mainPage = page(MainPage.class);
        this.mainPage.clickAccountButton();
        this.profilePage = page(ProfilePage.class);
        assertTrue("Profile page isn't displayed", this.profilePage.isProfilePageIsDisplayed());
        this.profilePage.clickLogo();
        assertTrue("Main page isn't displayed", this.mainPage.isMainPageLogoDisplayed());
        // back to account page
        this.mainPage.clickAccountButton();
        assertTrue("Profile page isn't displayed", this.profilePage.isProfilePageIsDisplayed());
        this.profilePage.clickConstructorButton();
        assertTrue("Profile page isn't displayed", this.profilePage.isProfilePageIsDisplayed());
        this.mainPage.clickAccountButton();
        this.profilePage.clickLogoutButton();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        assertTrue("Login page isn't displayed", this.loginPage.isLoginFormIsDisplayed());

    }
}
