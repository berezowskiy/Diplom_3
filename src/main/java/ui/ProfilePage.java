package ui;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class ProfilePage {

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private ElementsCollection headerButtons;

    @FindBy(how = How.CLASS_NAME, using = "input__container")
    private ElementsCollection profileFields;

    @FindBy(how = How.CLASS_NAME, using = "Account_button__14Yp3")
    private SelenideElement logoutButton;

    public void clickConstructorButton() { this.headerButtons.get(0).click(); }
    public void clickOrdersButton() { this.headerButtons.get(1).click(); }
    public void clickAccountButton() { this.headerButtons.get(2).click(); }
    public void clickLogoutButton() { this.logoutButton.click(); }
    public void clickLogo() { this.logo.click(); }
    public boolean isProfilePageIsDisplayed() { return this.logo.isDisplayed(); }
}
