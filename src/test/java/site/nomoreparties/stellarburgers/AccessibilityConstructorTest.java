package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.UserAccountPage;

public class AccessibilityConstructorTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    UserHelper userHelper;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        userAccountPage = new UserAccountPage(webDriver);
        userHelper = new UserHelper();
        userHelper.create();
    }

    @Test
    public void accessibilityConstructorTest() {
        mainPage.clickUserAccountLinkInHeader();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickUserAccountLinkInHeader();
        mainPage.clickConstructorLinkInHeader();
        mainPage.checkCreateOrderButton();
    }

    @After
    public void reset() {
        userHelper.delete();
    }
}
