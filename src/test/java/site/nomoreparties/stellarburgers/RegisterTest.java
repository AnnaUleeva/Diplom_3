package site.nomoreparties.stellarburgers;

import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.RegisterPage;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    UserHelper userHelper;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        userHelper = new UserHelper();
    }

    @Test
    public void registerUserTest() {
        mainPage.clickUserAccountLinkInHeader();
        loginPage.clickRegisterLink();
        registerPage.appendToNameInput(userHelper.getName());
        registerPage.appendToEmailInput(userHelper.getEmail());
        registerPage.appendToPasswordInput(userHelper.getPassword());
        registerPage.clickRegisterButton();
        loginPage.checkScreenTitle();
        reset();
    }

    @Test
    public void registerUserWithInvalidPasswordTest() {
        mainPage.clickUserAccountLinkInHeader();
        loginPage.clickRegisterLink();
        registerPage.appendToNameInput(userHelper.getName());
        registerPage.appendToEmailInput(userHelper.getEmail());
        registerPage.appendToPasswordInput("12345");
        registerPage.clickRegisterButton();
        assertEquals("Некорректный пароль", registerPage.checkPasswordError());
    }

    public void reset() {
        userHelper.login();
        userHelper.delete();
    }
}
