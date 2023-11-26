package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.UserAccountPage;

public class LogoutTest extends BaseTest {
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
    public void logoutTest() {
        mainPage.clickUserAccountLinkInHeader();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickUserAccountLinkInHeader();
        userAccountPage.clickLogoutButton();
        loginPage.checkScreenTitle();
    }

    @After
    public void reset() {
        userHelper.delete();
    }
}
