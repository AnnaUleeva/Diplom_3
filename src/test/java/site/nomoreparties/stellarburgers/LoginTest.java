package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Личный кабинет")
    @Description("Авторизация при переходе по ссылке 'Личный кабинет' в хедере")
    public void loginByUserAccountLinkInHeaderTest() {
        clickUserAccountLinkInHeader();
        appendToEmailInput();
        appendToPasswordInput();
        clickLoginButtonInLoginPage();
        checkCreateOrderButton();
    }

    @Test
    @DisplayName("Войти в акаунт")
    @Description("Авторизация при переходе по кнопке 'Войти в акаунт' на главной странице")
    public void loginByLoginButtonInMainPageTest() {
        clickLoginButtonInMainPage();
        appendToEmailInput();
        appendToPasswordInput();
        clickLoginButtonInLoginPage();
        checkCreateOrderButton();
    }

    @Test
    @DisplayName("Форма регистрации")
    @Description("Авторизация при переходе по ссылке 'Войти' на странице регистрации")
    public void loginByRegisterLinkInLoginPageTest() {
        clickLoginButtonInMainPage();
        clickRegisterLink();
        clickLoginLinkInRegisterPage();
        appendToEmailInput();
        appendToPasswordInput();
        clickLoginButtonInLoginPage();
        checkCreateOrderButton();
    }

    @Test
    @DisplayName("Форма восстановления пароля")
    @Description("Авторизация при переходе по ссылке 'Войти' на странице восстановлении пароля")
    public void loginByForgotPasswordLinkInLoginPageTest() {
        clickLoginButtonInMainPage();
        clickForgotPasswordLink();
        clickLoginLinkInForgotPasswordPage();
        appendToEmailInput();
        appendToPasswordInput();
        clickLoginButtonInLoginPage();
        checkCreateOrderButton();
    }

    @After
    public void reset() {
        userHelper.delete();
    }

    @Step("Переход по ссылке 'Личный кабинет' в хедере")
    void clickUserAccountLinkInHeader() {
        mainPage.clickUserAccountLinkInHeader();
    }

    @Step("Добавление email в поле ввода")
    void appendToEmailInput() {
        loginPage.appendToEmailInput(userHelper.getEmail());
    }

    @Step("Добавление пароля в поле ввода")
    void appendToPasswordInput() {
        loginPage.appendToPasswordInput(userHelper.getPassword());
    }

    @Step("Нажатие кнопки входа")
    void clickLoginButtonInLoginPage() {
        loginPage.clickLoginButton();
    }

    @Step("Проверка существования кнопки создать заказ после авторизации на главной странице")
    void checkCreateOrderButton() {
        mainPage.checkCreateOrderButton();
    }

    @Step("Нажатие кнопки 'Войти в акаунт' на главной странице")
    void clickLoginButtonInMainPage() {
        mainPage.clickLoginButton();
    }

    @Step("Нажатие ссылки 'Зарегистрироваться' на странице входа")
    void clickRegisterLink() {
        loginPage.clickRegisterLink();
    }

    @Step("Нажатие ссылки 'Войти' на странице регистрации")
    void clickLoginLinkInRegisterPage() {
        registerPage.clickLoginLink();
    }

    @Step("Нажатие ссылки 'Восстановить пароль' на странице входа")
    void clickForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    @Step("Нажатие ссылки 'Войти' на странице восстановления пароля")
    void clickLoginLinkInForgotPasswordPage() {
        registerPage.clickLoginLink();
    }
}
