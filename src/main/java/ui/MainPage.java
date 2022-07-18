package ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class MainPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site";
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private ElementsCollection headerButtons;
    @FindBy(how = How.CLASS_NAME, using = "tab_tab__1SPyG")
    private ElementsCollection burgerIngredientsButton;

    public void clickLoginButton() {
        this.enterButton.click();
    }
    public void clickAccountButton() { this.headerButtons.get(2).click(); }
    public void clickConstructorButton() { this.headerButtons.get(0).click(); }
    public boolean isMainPageLogoDisplayed() { return this.logo.isDisplayed(); }

    public void clickBunListButton() { this.burgerIngredientsButton.get(0).click(); }
    public void clickSauceListButton() { this.burgerIngredientsButton.get(1).click(); }
    public void clickIngredientListButton() { this.burgerIngredientsButton.get(2).click(); }

    public boolean isBunListDisplayed() {
        return $(byXpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']")).isDisplayed();
    }
    public boolean isSauceListDisplayed() {
        return $(byXpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']")).isDisplayed();
    }

    public boolean isIngredientListDisplayed() {
        return $(byXpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']")).isDisplayed();
    }


}
