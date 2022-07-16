package ui;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ConstructorNavigationTest {

    MainPage mainPage;

    @Before
    public void openMainPage() {
        // open main page
        this.mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
    }

    @Test
    public void checkBurgerConstructorNavigation() {

        this.mainPage.clickSauceListButton();
        assertTrue("Sauces list isn't displayed", this.mainPage.isSauceListDisplayed());

        this.mainPage.clickIngredientListButton();
        assertTrue("Ingredients list isn't displayed", this.mainPage.isIngredientListDisplayed());

        this.mainPage.clickBunListButton();
        assertTrue("Sauces list isn't displayed", this.mainPage.isBunListDisplayed());

    }

}
