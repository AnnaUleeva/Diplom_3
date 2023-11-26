package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.RegisterPage;

public class LoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
    UserHelper userHelper;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        userHelper = new UserHelper();
        userHelper.create();
    }

    @Test
    public void loginByUserAccountLinkInHeaderTest() {
        mainPage.clickUserAccountLinkInHeader();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    @Test
    public void loginByLoginButtonInMainPageTest() {
        mainPage.clickLoginButton();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    @Test
    public void loginByRegisterLinkInLoginPageTest() {
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    @Test
    public void loginByForgotPasswordLinkInLoginPageTest() {
        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.appendToEmailInput(userHelper.getEmail());
        loginPage.appendToPasswordInput(userHelper.getPassword());
        loginPage.clickLoginButton();
        mainPage.checkCreateOrderButton();
    }

    @After
    public void reset() {
        userHelper.delete();
    }
}
