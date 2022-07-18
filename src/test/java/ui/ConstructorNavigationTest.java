package ui;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ConstructorNavigationTest {

    MainPage mainPage;

    @Before
    public void openMainPage() {
        // open main page
        mainPage = open(MainPage.pageUrl, MainPage.class);
    }

    @Test
    public void checkBurgerConstructorNavigation() {

        mainPage.clickSauceListButton();
        assertTrue("Sauces list isn't displayed", mainPage.isSauceListDisplayed());
        mainPage.clickIngredientListButton();
        assertTrue("Ingredients list isn't displayed", mainPage.isIngredientListDisplayed());
        mainPage.clickBunListButton();
        assertTrue("Sauces list isn't displayed", mainPage.isBunListDisplayed());

    }

}
